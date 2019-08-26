package com.github.pawelhenek.scalaplayground.tourofscala

object classes extends App {

  class User

  val user1 = new User

  class Point(var x: Int, var y: Int) {
    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }

    override def toString: String = s"($x, $y)"
  }

  val point1 = new Point(2,3)
  println(point1.x)
  println(point1)

  class OtherPoint(var x: Int = 0, var y: Int = 0)

  val origin = new OtherPoint
  val pointX = new OtherPoint(1)
  println(pointX.x)

  val pointY = new OtherPoint(y = 1)
  println(pointY.y)

  class AnotherPointClass {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x = _x
    def x_= (newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning
    }

    def y = _y
    def y_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning
    }

    private def printWarning = println("WARNING: Out of bounds")
  }

  val anotherPoint = new AnotherPointClass
  anotherPoint.x = 99
  anotherPoint.y = 101

  class YetAnotherPoint(x: Int, y: Int)
  val yetAnotherPoint = new YetAnotherPoint(1, 2)
  //  yetAnotherPoint.x = 123 // does not compile

  println(yetAnotherPoint)

}
