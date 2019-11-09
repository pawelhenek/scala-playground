package com.github.pawelhenek.scalaplayground.tour_of_scala

object higherOrderFunctions extends App {

  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries1 = salaries.map(doubleSalary)

  println(salaries)
  println(newSalaries1)

  val newSalaries2 = salaries.map(x => x * 2)
  val newSalaries3 = salaries.map(_ * 2)

  case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
    private def convertCtoF(temp: Double) = temp * 1.8 + 2

    def foreacstInFahrenheit: Seq[Double] = temperatures.map(convertCtoF)
  }

  object SalaryRaiser {
    def smallPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * 1.1)

    def greatPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * salary)
  }

  object AnotherSalaryRaiser {
    private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
      salaries.map(promotionFunction)

    def smallPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * 1.1)

    def bigPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * salary)
  }

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  val domainName = "www.example.com"
  def getURL = urlBuilder(ssl=true, domainName)
  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query)

}
