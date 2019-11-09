package com.github.pawelhenek.scalaplayground.scala_school

object collections extends App {

  val arrayNumbers = Array(1,2,3,4,5,6,7,8,9,0)
  val listNumbers = List(1,2,3,4,5,6,7,8,9,0)
  val setNumbers = Set(1,2,3,4,5,6,7,8,9,0)

  val hostPort = ("localhost", 80)

  println(hostPort._1)
  println(hostPort._2)

  hostPort match  {
    case ("localhost", port) => "localhost with port"
    case (h, p) => "host port"
  }

  println( 1 -> 2 )

  println( Map( 3 -> 4) )

  println( Map( "foo" -> "bar" ) )

  println( 1 ->  Map( "foo" -> "bar" ) )

  trait Option[T] {
    def isDefined: Boolean
    def get: T
    def getOrElse(t: T): T
  }

  val numbers = Map("one" -> 1, "two" -> 2)
  println( numbers.get("two") )
  println( numbers.get("three") )

  val any = numbers.get("Any")

  val res = if (any.isDefined) {
    any.get * 2
  } else {
    0
  }

  println( res )

  val rez = any match {
    case Some(n) => n * 2
    case None => 0
  }

  println( rez )

  val numberz = List(1,2,3,4,5)
  println( numberz.map((i: Int) => i * 2) )

  def timesTwo(i: Int): Int = i * 2
  println( numberz.map(timesTwo) )

  numberz.foreach((i: Int) => i * 2)

  val doubled = numberz.foreach((i: Int) => i * 2)

  numberz.filter((i: Int) => i % 2 == 0)

  def isEven(i: Int) = i % 2 == 0
  numberz.foreach(isEven)

  println( List(1,2,3,4).zip(List("a", "b", "c")) )

  println( List(1,2,3,4,5,6,7,8,9).partition(_ % 2 == 0) )

  println( numberz.find((i: Int) => i > 5) )

  println( numberz.drop(5) )

  println( numberz.dropWhile(_ % 2 != 0) )

  println( numberz.foldLeft(0)((m: Int, n: Int) => m + n ) ) // sum

  numberz.foldLeft(0) {
    (m: Int, n: Int) => println(s"m: $m n: $n"); m + n
  }

  numberz.foldRight(0) {
    (m: Int, n: Int) => println(s"m: $m n: $n"); m + n
  }

  List(List(1,2), List(3,4)).flatten

  val nestedNumbers = List(List(1,2), List(3,4))
  nestedNumbers.flatMap(x => x.map(_ * 2))

  nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten

  def ourMap(numbers: List[Int], fn: Int => Int): List[Int] = {
    numbers.foldRight(List[Int]()) {
      (x: Int, xs: List[Int]) => fn(x) :: xs
    }
  }

  println( ourMap(numberz, timesTwo(_)) )



}
