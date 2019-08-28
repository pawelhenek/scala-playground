package com.github.pawelhenek.scalaplayground.tourofscala

object polimorphicMethods extends App {

  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else
      x :: listOfDuplicates(x, length - 1)
  }

  println(listOfDuplicates[Int](3,4))
  println(listOfDuplicates("La", 8))

}
