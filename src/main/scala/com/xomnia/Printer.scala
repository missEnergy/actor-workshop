package com.xomnia

import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]

  final case class Greeting(greeting: String)
  final case class Ellissa(george: Int)
}

class Printer extends Actor with ActorLogging {
  import Printer._

  def receive = {
    case Greeting(greeting) =>
      log.info(sender() + " says: " + greeting)

    case Ellissa(1) =>
      log.info(sender() + " george is one")

    case Ellissa(2) =>
      log.info(sender() + " george is big!")

  }

}
