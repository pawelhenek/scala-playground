package com.github.pawelhenek.scalaplayground.scala_school

object basics extends App {

  val two = 1 + 1

  var name1 = "steve"
  val name2 = "marius"

  def addOne(m: Int): Int = m + 1
  val three = addOne(2)

  def threee() = 1 + 2

  threee()
  def adder(m: Int, n: Int) = m + n

  val add2 = adder(2, _:Int)

  println( add2(3) )

  def multiply(m: Int)(n: Int): Int = m * n

  println( multiply(2)(3) )

  val timesTwo = multiply(2) _

  println( timesTwo(2) )

  val curriedAdd = (adder _).curried

  val addTwo = curriedAdd(3)

  println( addTwo(4) )

  def capitalizeAll(args: String*): Unit = {
    args.map { arg =>
      arg.capitalize
    }
  }

  println( capitalizeAll("rabbit", "sun") )

  class Calculator {
    val brand: String = "HP"
    def add(m: Int, n: Int): Int = m + n
  }

  val calc = new Calculator
  calc.add(1,2)

  calc.brand

  class Zalculator(brand: String) {

    var color: String = if (brand == "TI") {
      "blue"
    } else if (brand == "HP") {
      "black"
    } else {
      "white"
    }

    def add(m: Int, n: Int) = m + n
  }

}
