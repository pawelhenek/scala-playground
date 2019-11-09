package com.github.pawelhenek.scalaplayground.tour_of_scala

object typeInference extends App {

  val businessName = "Montreux Jazz Cafe"

  def squareOf(x: Int) = x * x

  // this brakes compilation
//  def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)

  case class MyPair[A, B](x: A, y: B)
  val p = MyPair(1, "scala")

  def id[T](x: T) = x
  val q = id(1)

  Seq(1,2,3).map(x => x * 2)

  var obj = null
  // this brakes compilation
//  obj = new AnyRef

}
