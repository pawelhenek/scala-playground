package com.github.pawelhenek.scalaplayground.tourofscala

object caseClasses extends App {

  case class Book(isbn: String)

  val frankenstein = Book("978-0486282114")

  case class Message(sender: String, recipient: String, body: String)
  val message1 = Message("guillamaue@quebec.ca", "jorge@catalonia.es", "Hello")

  println(message1.sender)

}
