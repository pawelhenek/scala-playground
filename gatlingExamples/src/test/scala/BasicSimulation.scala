
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val baseurl = "http://www.google.com"
  val httpConf = http.baseUrl(baseurl)

  val scn = scenario("Just ask google")
    .exec(
      http("Request")
        .get(baseurl)
        .check(status.is(200)))

  setUp(scn.inject(atOnceUsers(5))).protocols(httpConf)
}
