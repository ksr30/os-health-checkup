package com.knoldus

import akka.actor.ActorRef


case class MessageStructure(message:String,collectorAddress:ActorRef)
