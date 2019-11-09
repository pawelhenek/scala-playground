package com.github.pawelhenek.scalaplayground.tour_of_scala

import scala.math._
import com.github.pawelhenek.scalaplayground.tour_of_scala.logger.info

object singletons extends App {

  object Box

  class Project(name: String, daysToComplete: Int)

  class Test {
    val project1 = new Project("TPS reports", 1)
    val project2 = new Project("Website redesign", 5)
    info("Created projects")
  }

  case class Circle(radius: Double) {
    import Circle._
    def area: Double = calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  val circle1 = new Circle(5.0)

  circle1.area

  class Email(val username: String, val domainName: String)

  object Email {
    def fromString(emailString: String): Option[Email] = {
      emailString.split('@') match {
        case Array(a, b) => Some(new Email(a, b))
        case _ => None
      }
    }
  }

  val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
  scalaCenterEmail match {
    case Some(email) => println(
      s"""Registered an email
         |Username: ${email.domainName}
         |Domain name: ${email.domainName}
         """)
    case None => println("Error could not parse email")
  }

}
