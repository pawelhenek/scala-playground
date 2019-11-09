package com.github.pawelhenek.scalaplayground.tour_of_scala

import scala.util.Random

object extractorObjects extends App {

  object CustomerID {
    def apply(name: String) = s"$name--${Random.nextLong}"

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split("--")
      if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
  }

  val customer1ID = CustomerID("Sukyoung")
  println(customer1ID)

  customer1ID match {
    case CustomerID(name) => println(name)
    case _ => println("Could not extract a CustomerID")
  }

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID
  println(name)


//  val name2  = CustomerID.unapply(customer2ID).get
  val CustomerID(name2) = "--asdfasdfasdf"

  val CustomerID(name3) = "--asdfasdfasdf"
}
