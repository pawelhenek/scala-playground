package com.github.pawelhenek.scalaplayground.scala_school

import scala.concurrent.Future

object advanced_types extends App {

  // View bounds

  implicit def strToInt(x: String) = x.toInt

  "123"

  val y : Int = "123"

  math.max("123", 111)

  // Other type bounds

  class Container1[A <% Int] {
    def addIt(x: A) = 123 + x
  }

  println( (new Container1[String]).addIt("123") )

  println( (new Container1[Int]).addIt(123) )

  // (new Container[Float]).addIt(123.2F)

  class Container2[A](value: A) {
    def addIt(implicit evidence: A =:= Int) = 123 + value
  }

  println( (new Container2(123)).addIt )

  //  println( (new Container2("123")).addIt )

  val seq = Seq(1,2,3,4)

  println( seq.min )

  println(
    List(1,2,3,4,5).min(new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = x compare y
    })
  )

  trait LowPriorityOrderingImplicits {
    implicit def ordered[A <: Ordered[A]]: Ordering[A] = new Ordering[A] {
      override def compare(x: A, y: A): Int = x compare y
    }
  }

  def foo[A](implicit x: Ordered[A]) { }
  def foo2[A : Ordered] { }

  implicitly[Ordering[Int]]

  // Higher-kinded types & ad-hoc polymorphism

  trait Container[M[_]] {
    def put[A](x: A): M[A]
    def get[A](m: M[A]): A
  }

  val container = new Container[List] {
    override def put[A](x: A): List[A] = List(x)
    override def get[A](m: List[A]): A = m.head
  }

  println( container.put("A") )
  println( container.put(123) )

  implicit val listContainer = new Container[List] {
    override def put[A](x: A): List[A] = List(x)
    override def get[A](m: List[A]): A = m.head
  }

  implicit val optionContainer = new Container[Some] {
    override def put[A](x: A): Some[A] = Some(x)
    override def get[A](m: Some[A]): A = m.get
  }

  def tupleize[M[_]: Container, A, B](fst: M[A], snd: M[B]) = {
    val c = implicitly[Container[M]]
    c.put(c.get(fst), c.get(snd))
  }

  println( tupleize(Some(1), Some(2)) )

  println( tupleize(List(1), List(2)) )

  // F-bounded polymorphism

  trait Containerr[A] extends Ordered[A]

  class MyContainer extends Containerr[MyContainer] {
    override def compare(that: MyContainer): Int = 0
  }

  class StringContainer extends Containerr[String] {
    override def compare(that: String): Int = 0
  }

  trait FContainer[A <: FContainer[A]] extends Ordered[A]

  class MajContainer extends FContainer[MajContainer] {
    override def compare(that: MajContainer): Int = 0
  }

  val majContainers = List(new MajContainer, new MajContainer, new MajContainer)

  val mins = List(new MajContainer, new MajContainer, new MajContainer).min

  class YourContainer extends FContainer[YourContainer] {
    override def compare(that: YourContainer): Int = 0
  }

  val containers = List(new MyContainer, new YourContainer)

  // structural types

  def foo(x: { def get: Int}) = 123 + x.get

  println( foo(new { def get = 10 }) )

  // abstract type members

  trait Foo {
    type A;
    val x: A;
    def getX: A = x
  }

  println( (new Foo { type A = Int; val x = 123 }).getX )

  println( (new Foo { type A = String; val x = "key" }).getX )

  trait Foo2[M[_]] { type t[A] = M[A] }
  val x : Foo2[List]#t[Int] = List(1)

  // type erasures & manifests

  class MakeFoo[A](implicit mainfest: Manifest[A]) {
    def make: A = mainfest.erasure.newInstance.asInstanceOf[A]
  }

  (new MakeFoo[String]).make

}
