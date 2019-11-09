package com.github.pawelhenek.scalaplayground.tour_of_scala

object caseClasses extends App {

  case class Book(isbn: String)

  val frankenstein = Book("978-0486282114")

  case class Message(sender: String, recipient: String, body: String)
  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

  println(message1.sender)

  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")

  println( message2 == message3 )

  val message4 = message3.copy(sender = message3.recipient, recipient = message3.sender)

  println(message4)

}
