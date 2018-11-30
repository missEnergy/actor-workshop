package com.xomnia

import akka.actor.{Actor, ActorLogging, Props}


object SumCalculator {
  def props(numbers: Array[Int]): Props = Props(new SumCalculator(numbers))

  final case class Result(result: BigInt)
}

class SumCalculator(numbers: Array[Int]) extends Actor with ActorLogging {
  import SumCalculator._

  override def preStart() = ???

  override def receive: Receive = ???

}
