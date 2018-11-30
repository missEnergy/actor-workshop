package com.xomnia

import akka.actor.{Actor, ActorRef, Props}
import com.xomnia.Printer.Greeting

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  final case class Greet(who: String)
  final case class PrintInternalMessage()
  final case class ReplaceGreet(replacer: String)
}

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._

  var _message: String = ""

  def receive = {
    case Greet(who) =>
      val greeting = message + ", " + who
      printerActor ! Greeting(greeting)

    case PrintInternalMessage() =>
      printerActor ! Greeting(_message)

    case ReplaceGreet(replacer) =>
      _message = replacer
  }
}
