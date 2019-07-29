package com.github.pawelhenek.scalaplayground

import scala.concurrent._, duration._

case class SimpleParsed(id: Long, text: String)

object Hello extends App {
  val w = Await.result(Weather.weather, 10.seconds)
  println(s"Hello! The weather in New York is $w.")
  Weather.http.close()
}
