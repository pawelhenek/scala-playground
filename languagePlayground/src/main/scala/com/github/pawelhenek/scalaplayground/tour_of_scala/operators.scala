package com.github.pawelhenek.scalaplayground.tour_of_scala

object operators extends App {

  println(10.+(1))
  println(10 + 2)

  case class Vec(x: Double, y: Double) {
    def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)
  }

  val vector1 = Vec(1.0, 1.0)
  val vector2 = Vec(2.0, 2.0)

  val vector3 = vector1+vector2

  case class MyBool(x: Boolean) {
    def and(that: MyBool): MyBool = if (x) that else this
    def or(that: MyBool): MyBool = if (x) this else that
    def negate: MyBool = MyBool(!x)
  }

  def not(x: MyBool) = x.negate
  def xor(x: MyBool, y: MyBool) = (x or y) and not(x and y)

}
