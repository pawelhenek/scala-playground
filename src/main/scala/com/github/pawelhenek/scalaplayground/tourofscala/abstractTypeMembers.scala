package com.github.pawelhenek.scalaplayground.tourofscala

object abstractTypeMembers extends App {

  trait Buffer {
    type T
    val element: T
  }

  abstract class SeqBuffer extends Buffer {
    type U
    type T <: Seq[U]
    def length = element.length
  }

  abstract class IntSeqBuffer extends SeqBuffer {
    type U = Int
  }

  def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
    new IntSeqBuffer {
      type T = List[U]
      val element = List(elem1, elem2)
    }

  val buf = newIntSeqBuf(7, 8)
  println("length = " + buf.length)
  println("content = " + buf.element)


  abstract class Zuffer[+T] {
    val element: T
  }

  abstract class SeqZuffer[U, +T <: Seq[U]] extends Zuffer[T] {
    def length = element.length
  }

  def newIntSeqZuf(e1: Int, e2: Int): SeqZuffer[Int, Seq[Int]] =
    new SeqZuffer[Int, List[Int]] {
      val element = List(e1, e2)
    }

  val zuf = newIntSeqZuf(7, 8)
  println("length = " + zuf.length)
  println("content = " + zuf.element)

}
