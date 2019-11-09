package com.github.pawelhenek.scalaplayground.tour_of_scala

import scala.util.Random

object patternMatching extends App {

  val x: Int = Random.nextInt(10)

  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "other"
  }

  println( matchTest(3) )
  println( matchTest(1) )

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification
  case class Sms(caller: String, message: String) extends Notification
  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case Sms(number, message) =>
        s"You got an Sms from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a voice recording from $name! click the link to hear it $link"
    }
  }

  val someSms = Sms("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org")

  println( showNotification(someSms) )
  println( showNotification(someVoiceRecording) )

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from special someone!"
      case Sms(number, _) if importantPeopleInfo.contains(number) =>
        "You got an Sms from special someone!"
      case other =>
        showNotification(other)
    }
  }

  val importantPeopleInfo = Seq("876-5309", "jenny@gmail.com")

  val someOtherSms = Sms("876-5309", "Are you there?")
  val someVoicerecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = Sms("867-5309", "I'm here! Where are you?")

  println( showImportantNotification(someSms, importantPeopleInfo) )
  println( showImportantNotification(someVoiceRecording, importantPeopleInfo) )
  println( showImportantNotification(importantEmail, importantPeopleInfo) )
  println( showImportantNotification(importantSms, importantPeopleInfo) )

  abstract class Device

  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }

  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen"
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case p: Computer => p.screenSaverOn
  }

  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }



}
