package com.github.pawelhenek.scalaplayground.scala_school

object pattern_matching_and_functional_composition extends App {

  def f(s: String) = "f(" + s + ")"

  def g(s: String) = "g(" + s + ")"

  val fComposeG = f _ compose g _

  println( fComposeG("yay") )

  val fAndThenG = f _ andThen g _

  println( fAndThenG("yay") )

  val one: PartialFunction[Int, String] = { case 1 => "one" }

  one.isDefinedAt(1)

  one.isDefinedAt(2)

  val o = one(1)

  println( o )

}
