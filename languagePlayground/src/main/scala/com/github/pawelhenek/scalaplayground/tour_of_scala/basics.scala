package com.github.pawelhenek.scalaplayground.tour_of_scala

object basics extends App {

  println(1)
  println("Hello world!")

  val x = 1 + 1
  println(x)

  val y : Int = 1 + 1

  println (x * y)

  println({
    val x = 1 + 1
    x + 1
  })

  val addOne = (x : Int) => x + 1
  println(addOne(1))

  val add = (x: Int, y: Int) => x + y
  println(add(1,2))

  val getTheAnswer = () => 42
  println(getTheAnswer())

  class SomeClass {
    def add(x: Int, y: Int): Int = x + y
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    def name: String = "System error"
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }
  }

  println(new SomeClass().add(2, 3))
  println(new SomeClass().addThenMultiply(1,2)(3))
  println(new SomeClass().name)
  println(new SomeClass().getSquareString(3.14))

  class SomeClassWithConstructor(prefix: String, suffix: String) {
    def greet(name: String): Unit = {
      println(prefix + name + suffix)
    }
  }

  println(new SomeClassWithConstructor("Pre", "Post").greet("github"))

  case class Point(x: Int, y : Int)

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(0, 1)

  if (point == anotherPoint) println("points are the same")
  else println("points are different")

  if (point == yetAnotherPoint) println("points are the same")
  else println("points are different")

  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }

  val newId : Int = IdFactory.create()
  print(newId)
  val newerId : Int = IdFactory.create()
  print(newerId)

  trait Greeter {
    def greet(name : String): Unit

    def sayHello(name : String): Unit = println("Hello," + name + "!")
  }

  class DefaultGreeter extends Greeter {
    override def greet(name: String): Unit = println("Greetings, " + name)
  }

  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

  val greeter = new DefaultGreeter()
  greeter.greet("Scala developer")

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer")


}
