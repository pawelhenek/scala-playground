package com.github.pawelhenek.scalaplayground.tour_of_scala

object compoundTypes extends App {

  trait Cloneable extends java.lang.Cloneable {
    override def clone(): Cloneable = {
      super.clone().asInstanceOf[Cloneable]
    }
  }

  trait Resetable {
    def reset: Unit
  }

  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }

}
