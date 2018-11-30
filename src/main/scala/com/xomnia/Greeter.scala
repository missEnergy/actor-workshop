package com.xomnia

import akka.actor.{Actor, ActorRef, Props}
import com.xomnia.Printer.Greeting

object Greeter {
  def props(message: String, printerActor: ActorRef): Props = Props(new Greeter(message, printerActor))

  final case class Greet(who: String)
}

class Greeter(message: String, printerActor: ActorRef) extends Actor {
  import Greeter._

  def receive = {
    case Greet(who) =>
      val greeting = message + ", " + who
      printerActor ! Greeting(greeting)

  }

}
