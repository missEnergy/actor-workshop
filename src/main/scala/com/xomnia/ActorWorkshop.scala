package com.xomnia

import akka.actor.{ActorRef, ActorSystem}
import com.xomnia.Greeter.{PrintInternalMessage, ReplaceGreet}
import com.xomnia.Printer.{Ellissa, Greeting}


object ActorWorkshop extends App {

  val system: ActorSystem = ActorSystem("actorWorkshop")

  val printer: ActorRef = system.actorOf(Printer.props, "printerActor")

  printer ! Greeting("Hello world!")
  printer ! Ellissa(2)

  val greeter: ActorRef = system.actorOf(Greeter.props("hi", printer), "greeterActor")

  greeter ! PrintInternalMessage()
  greeter ! ReplaceGreet("Marilena")
  greeter ! PrintInternalMessage()

}
