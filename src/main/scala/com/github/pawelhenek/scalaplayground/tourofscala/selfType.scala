package com.github.pawelhenek.scalaplayground.tourofscala

object selfType extends App {

  trait User {
    def username: String
  }

  trait Tweeter {
    this: User => def tweet(tweetTxt: String) = println(s"$username: $tweetTxt")
  }

  class VerifiedTweeter(val username_ : String) extends Tweeter with User {
    def username = s"real $username_"
  }

  val realBeyonce = new VerifiedTweeter("Beyonce")
  realBeyonce.tweet("Just spilled my glass of lemonade")

}
