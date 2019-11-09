package com.github.pawelhenek.scalaplayground.tour_of_scala

object namedArguments extends App {

  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }

  printName("John", "Smith")
  printName(first = "John", last = "Smith")
  printName(last = "Smith", first = "John")

}
