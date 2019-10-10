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

  class ScientificCalculator(brand: String) extends Zalculator(brand) {
    def log(m: Double, base: Double) = math.log(m) / math.log(base)
  }

  class EventMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
    def log(m: Int): Double = log(m, math.exp(1))
  }

  abstract class Shape {
    def getArea(): Int
  }

  class Circle(r: Int) extends Shape {
    override def getArea(): Int = { r * r * 3 }
  }

  val c = new Circle(3)

  class C {
    var acc = 0
    def minc = { acc += 1 }
    val finc = { () => acc += 1 }
  }

  trait Car {
    val brand: String
  }

  trait Shiny {
    val shineRefraction: Int
  }

  trait BMW extends Car {
    val brand = "BMW"
  }

  class BMW2 extends Car with Shiny {
    val brand = "BMW2"
    val shineRefraction = 12
  }

  trait Cache[K, V] {
    def get(key: K): V
    def put(key: K, value: V)
    def delete(key: K)
    def remove[K](key: K)
  }
}
