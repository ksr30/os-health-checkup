package com.knoldus

import akka.actor.Actor

import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global

case class ReturnF()
case class Result(errorCounter:Int,warningCouter:Int,infoCounter:Int)

class CollectorActor extends Actor {
  var totalNoErrors:Int = 0
  var totalNoWarnings:Int = 0
  var totalNoInfo:Int = 0
  def receive:Receive={
    case "[ERROR]" => totalNoErrors+=1
    case "[WARN]" => totalNoWarnings+=1
    case "[INFO]" => totalNoInfo+=1
    case ReturnF()=> {
      Result(totalNoErrors,totalNoWarnings,totalNoWarnings)


    }


  }

  override def postStop={
    println(totalNoWarnings)
    println(totalNoInfo)
  }

}
