package com.github.pawelhenek.scalaplayground

import gigahorse._, support.okhttp.Gigahorse
import scala.concurrent._, duration._
import play.api.libs.json._


object Weather {
  lazy val http = Gigahorse.http(Gigahorse.config)

  def weather: Future[String] = {
    val baseUrl = "https://www.metaweather.com/api/location"
    val locationUrl = baseUrl + "/search"
    val weatherUrl = baseUrl + "/%s"
    val resourceLocation = Gigahorse.url(locationUrl).get
      .addQueryString("query" -> "New York")
    import ExecutionContext.Implicits.global

    for {
      loc <- http.run(resourceLocation, parse)
      woeid = (loc \ 0 \ "woeid").get
      rWeather = Gigahorse.url(weatherUrl format woeid).get
      weather <- http.run(rWeather, parse)
    } yield (weather \\ "weather_state_name")(0).as[String].toLowerCase
  }

  private def parse = Gigahorse.asString andThen Json.parse
}
