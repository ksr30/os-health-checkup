package com.knoldus

import akka.actor.{Actor, ActorRef, Props}

import scala.io.Source

class FileMiner extends Actor {
  def receive:Receive={
    case MessageStructure(file,collectorRef)=> {
      val lines = Source.fromFile(file).getLines.toList
      errorWarningFinder(lines,collectorRef)


    }
  }

  def errorWarningFinder(lines:List[String],collectorActor: ActorRef):String={
    lines match{
      case Nil=> "Process Completed"
      case line::restOfLines=> {
        val healthFinderActor=context.system.actorOf(Props[ErrorWarningFinder])
        healthFinderActor ! MessageStructure(line,collectorActor)
        errorWarningFinder(restOfLines,collectorActor)
      }
    }
  }

  override def postStop(): Unit = {
    print("ksr")
  }

}
