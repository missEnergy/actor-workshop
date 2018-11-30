package com.xomnia

import akka.actor.{Actor, ActorLogging, ActorRef, Props}


object Dispatcher {
  def props: Props = Props[Dispatcher]

  final case class Sum(numbers: Array[Int])
}

class Dispatcher extends Actor with ActorLogging {
  import Dispatcher._
  import SumCalculator._

  var workers = Map.empty[ActorRef, ActorRef]

  override def receive: Receive = ???

}
