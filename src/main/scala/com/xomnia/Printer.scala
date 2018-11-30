package com.xomnia

import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]

  final case class Greeting(greeting: String)
}

class Printer extends Actor with ActorLogging {
  import Printer._

  def receive = {
    case Greeting(greeting) =>
      log.info(sender() + " says: " + greeting)
  }

}
