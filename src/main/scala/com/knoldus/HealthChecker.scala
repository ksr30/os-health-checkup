package com.knoldus

import java.io.File

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

import akka.actor.{ActorSystem, Props}
import akka.dispatch.ExecutionContexts._
import akka.pattern.ask
import akka.util.Timeout


class HealthChecker(path:String) {
  connector()
  def connector(): Any={
    val actorSystem=ActorSystem("firstActorSystem")
    val collectorActor=actorSystem.actorOf(Props[CollectorActor])

    +





























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































    +++++
    ++++++
    +
    val fileList:List[String]=fileFinder(path)
    fileMinerActorCaller(fileList,actorSystem,collectorActor)
    implicit val timeout = Timeout(10 seconds)
    val future = collectorActor ? ReturnF()






  }

  def fileFinder(path:String):List[String]={
    val filePointer = new File(path)
    filePointer.listFiles.toList.map(_.toString)
  }

  def fileMinerActorCaller(files: List[String],actorSystem: ActorSystem,collectorActor: ActorRef):String={
    files match{
      case Nil=> " "
      case file::restOfFiles=>
        val fileMinerActor= actorSystem.actorOf(Props[FileMiner])
        fileMinerActor ! MessageStructure(file,collectorActor)
        fileMinerActorCaller(restOfFiles,actorSystem,collectorActor)
    }
  }




}
