package com.github.pawelhenek.scalaplayground.tourofscala

object unifiedTypes extends App {

  val list: List[Any] = List(
    "a string",
    732,
    'c',
    true,
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))

  val x: Long = 987654321
  val y: Float = x

  val face: Char = '☺'
  val number: Int = face

  val x1: Long = 987654321
  val x2: Float = x1



}
