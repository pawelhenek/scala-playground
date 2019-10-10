package com.github.pawelhenek.scalaplayground.scala_school

import com.sun.xml.internal.ws.developer.ServerSideException

object basics_continued extends App {

  class Foo {}

  object FooMaker {
    def apply() = new Foo
  }

  val newFoo = FooMaker()

  class Bar {
    def apply() = 0
  }

  val bar = new Bar
  println( bar() )

  object Timer {
    var count = 0

    def currentCount(): Long = {
      count += 1
      count
    }
  }

  println( Timer.currentCount() )

  class Barr(foo: String)

  object Barr {
    def apply(foo: String) = new Barr(foo)
  }

  object addOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  println( addOne(1) )

  class AddOne extends ((Int) => Int) {
    def apply(m: Int): Int = m + 1
  }

  val plusOne = new AddOne()

  println( plusOne(1) )

  val times = 1

  times match {
    case 1 => "one"
    case 2 => "two"
    case _ => "some other number"
  }

  times match {
    case i if i == 1 => "one"
    case i if i == 2 => "two"
    case _ => "some other number"
  }

  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 => i - 1
      case i: Int => i + i
      case d: Double if d < 0.0 => d - 0.1
      case d: Double => d + 0.1
      case text: String => text + "s"
    }
  }

  case class Calculator(brand: String, model: String)

  def calcType(calc: Calculator) =  calc match {
    case _ if calc.brand == "HP" && calc.model == "20B" => "financial"
    case _ if calc.brand == "HP" && calc.model == "48G" => "scientific"
    case _ if calc.brand == "HP" && calc.model == "30B" => "business"
    case _ => "unkknown"
  }

  val hp20b = Calculator("HP", "20b")
  val hp20B = Calculator("HP", "20b")

  println( hp20b == hp20B )

  def calculatorType(calc: Calculator) = calc match {
    case Calculator("HP", "20B") => "financial"
    case Calculator("HP", "48G") => "scientific"
    case Calculator("HP", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s if of unknown type".format(ourBrand, ourModel)
    case _ => "Calculator of unknown type"
  }

  class RemoteService {
    def add(a: Int, b: Int) = a + b
    def close() = {

    }
  }

  val remoteCalculatorService = new RemoteService

  try {
    remoteCalculatorService.add(1,2)
  } catch {
    case e: ServerSideException => println("remote calculator not available")
  } finally {
    remoteCalculatorService.close()
  }

  val result: Int = try {
    remoteCalculatorService.add(3,4)
  } catch {
    case e: ServerSideException => {
      println("remote calculator not available")
      0
    }
  } finally {
    remoteCalculatorService.close()
  }


}
