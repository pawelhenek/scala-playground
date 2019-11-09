package com.github.pawelhenek.scalaplayground.scala_school

object type_and_polymorphism_basics extends App {

  val lst = 2 :: 1 :: "bar" :: "foo" :: Nil

  println(lst)

  println( lst.head )

  def drop1[A](l: List[A]) = l.tail

  println( drop1(List(1,2,3,4)) )

  def toList[A](a: A) = List(a)

  // def foo1[A, B](f: A => List[A], b: B) = f(b)

  // def foo2[A](f: A => List[A], i: Int) = f(i)

  def id[T](x: T) = x

  val x = id(321)

  println( x )

  val s = id("hey")

  val a = id(Array(1,2,3))

  class Covariant[+A]

  val cv1 : Covariant[AnyRef] = new Covariant[String]
  // val cv1_2 : Covariant[String] = new Covariant[A]

  class Contravariant[-A]

  val cv2 : Contravariant[String] = new Contravariant[AnyRef]
  // val cv2_2 : Contravariant[AnyRef] = new Contravariant[String]

  trait Function1 [ -T1, +R ] extends AnyRef

  class Animal {
    val sound = "rustle"
  }

  class Bird extends Animal{
    override val sound = "call"
  }

  class Chicken extends Bird {
    override val sound: String = "cluck"
  }

  val getTweet: (Bird => String) = ((a: Animal) => a.sound)
  val hatch: (() => Bird) = (() => new Chicken)

  def biophony[T <: Animal](things: Seq[T]) = things map (_.sound)
  // def cacophony[T](things: Seq[T]) = things map (_.sound)

  biophony(Seq(new Chicken, new Bird))

  val flock = List(new Bird, new Bird)

  println( new Chicken :: flock )

  println( new Animal :: flock )

  def count1[A](l: List[A]) = l.size
  def count2(l: List[_]) = l.size
  def count3(l: List[T forSome { type T }]) = l.size

  def dropOne1(l: List[_]) = l.tail
  def dropOne2(l: List[T forSome { type T }]) = l.tail

  def hashcodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
  // println( hashcodes(Seq(1,2,3)) )

  println( hashcodes(Seq("one", "two", "three")) )

}
