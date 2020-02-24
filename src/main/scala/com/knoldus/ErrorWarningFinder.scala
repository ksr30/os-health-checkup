package com.knoldus

import akka.actor.Actor
import scala.io.Source
import akka.actor.Props

class ErrorWarningFinder extends Actor {

  def receive:Receive={
    case MessageStructure(line,collectorAddress) if(line.contains("[ERROR]")) => collectorAddress ! "[ERROR]"
    case MessageStructure(line,collectorAddress) if(line.contains("[WARN]")) => collectorAddress ! "[WARN]"
    case MessageStructure(line,collectorAddress) if(line.contains("[INFO]")) => collectorAddress ! "[INFO]"
  }

}
