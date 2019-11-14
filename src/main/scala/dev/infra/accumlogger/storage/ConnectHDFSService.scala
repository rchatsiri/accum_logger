package dev.infra.accumlogger.storage

import org.apache.spark.SparkContext
import org.apache.spark.streaming.flume.SparkFlumeEvent
import org.apache.spark.streaming.dstream.DStream

class ConnectHDFSService {
  def writeInfo(infoType: String, recInputStream: DStream[String], urlHDFS: String): Boolean = { 
    true
  }
}