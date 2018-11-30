package com.xomnia

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}


object SumCalculator {
  def props(numbers: Array[Int]): Props = Props(new SumCalculator(numbers))

  final case class Result(result: BigInt)
}

class SumCalculator(numbers: Array[Int]) extends Actor with ActorLogging {
  import SumCalculator._

  var partialResults = List[BigInt]()

  override def preStart() = {
    numbers.length match {
      case 1 =>
        context.parent ! Result(numbers(0))
        context.stop(self)
      case 2 =>
        context.parent ! Result(numbers(0) + numbers(1))
        context.stop(self)
      case _ => {
        context.actorOf(SumCalculator.props(numbers.take(2)), "left")
        context.actorOf(SumCalculator.props(numbers.drop(2)), "right")
      }
    }

  }

  override def receive: Receive = {
    case Result(result) =>
      partialResults = result :: partialResults
      if (partialResults.length == 2)
        context.parent ! Result(partialResults(0) + partialResults(1))
        context.stop(self)
  }

}
