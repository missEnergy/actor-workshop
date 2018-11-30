package com.xomnia

import akka.actor.{Actor, ActorIdentity, ActorLogging, ActorPath, Identify, Props}

object ActorIdentifier {
  def props: Props = Props[ActorIdentifier]

}

class ActorIdentifier extends Actor with ActorLogging {
  import ActorIdentifier._

  def receive = ???

}
