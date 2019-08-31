package com.github.pawelhenek.scalaplayground.tourofscala

object defaultParameterValues extends App {

  def log(message: String, level: String = "INFO") = println(s"$level: $message")

  log("System starting")
  log("User not found", "WARNING")

  class Point(val x: Double = 0, val y: Double = 0)

  val point = new Point(y = 1)



}
