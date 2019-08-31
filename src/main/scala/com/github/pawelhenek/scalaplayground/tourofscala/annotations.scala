package com.github.pawelhenek.scalaplayground.tourofscala

import scala.annotation.tailrec

object annotations extends App {

  @deprecated("depr msg", "release # which deprecates method")
  def hello = "hola"

  hello

  def factorial(x: Int): Int = {

    @tailrec
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
    }
    factorialHelper(x, 1)
  }


  // this brakes compilation
//  def anotherFactorial(x: Int): Int = {
//
//    @tailrec
//    def factorialHelper(x: Int): Int = {
//      if (x == 1) 1 else x * factorialHelper(x - 1)
//    }
//    factorialHelper(x)
//  }

}
