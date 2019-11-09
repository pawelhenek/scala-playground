package com.github.pawelhenek.scalaplayground.tour_of_scala

object implicitConversions extends App {

  implicit def list2ordered[A](x: List[A])
    (implicit elem2ordered: A => Ordered[A]): Ordered[List[A]] =
      new Ordered[List[A]] {
        def compare(that: List[A]): Int = 1
      }

  List(1, 2, 3) <= List(4, 5)

  implicit def int2Integer(x: Int) =
    java.lang.Integer.valueOf(x)

}
