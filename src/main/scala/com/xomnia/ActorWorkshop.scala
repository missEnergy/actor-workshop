package com.xomnia

import akka.actor.{ActorRef, ActorSystem}
import com.xomnia.Greeter.Greet
import com.xomnia.Printer.Greeting


object ActorWorkshop extends App {
  val system: ActorSystem = ActorSystem("actorWorkshop")

  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

  printer ! Greeting("Hello world!")

}
