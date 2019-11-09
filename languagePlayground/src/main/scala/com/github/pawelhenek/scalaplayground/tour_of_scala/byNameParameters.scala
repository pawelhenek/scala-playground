package com.github.pawelhenek.scalaplayground.tour_of_scala

object byNameParameters extends App {

  def calculate(input: => Int) = input * 37

  def whileLoop(condition: => Boolean)(body: => Unit): Unit =
    if (condition) {
      body
      whileLoop(condition)(body)
    }

  var i = 2

  whileLoop(i > 0) {
    println(i)
    i -= 1
  }

}
