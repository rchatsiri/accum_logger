package dev.infra.accumlogger

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.SparkConf
import com.typesafe.scalalogging.LazyLogging 
import org.apache.spark.streaming.dstream.DStream
import java.net.InetAddress 
import org.apache.spark.streaming.flume.FlumeUtils 
import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime
import dev.infra.accumlogger.utils.DateUtils

class AggregateLoggerService extends LazyLogging {

  def getIPAddress(): String = {
    val localhost: InetAddress = InetAddress.getLocalHost
    val localIpAddress: String = localhost.getHostAddress
    localIpAddress
  }
   
  

  // Support push base
  def receiveFlumeLogging(appName: String, sparkNode: String): Unit = {
    val conf = new SparkConf().setMaster(sparkNode).setAppName(appName)
    val ssc = new StreamingContext(conf, Seconds(30))
    ssc.sparkContext.setCheckpointDir("hdfs://10.10.100.11:9000/user/flume/checkpoint/jdb/")
    val date = DateUtils.getCurrentDate();
    val hour = DateUtils.getCurrentHour();
    val currentPath = date+"/server-log/"+hour;
    println("CURRENT PATH["+currentPath+"]");
    val fileStream = ssc.textFileStream("hdfs://10.10.100.11:9000/user/flume/jdb/"+currentPath); 
    val ret = fileStream.filter(x => x.matches("\\[\\w*].\\d{17}.\\w[system|transaction|access]*.\\w[DEBUG|INFO]"))
    ret.print()
    ssc.start()
    ssc.awaitTermination();
  }

}


 /* Flume direct stream 
    val flumeStream = FlumeUtils.createStream(ssc, "localhost", 9988)

    
    val data : DStream[String] = flumeStream.map(x => new String(x.event.getBody.array()))
    data.filter(_.matches("") == "system ERROR")
    data.print();
    
     
      
    flumeStream.count().map(cnt => "Received ["+cnt+"] flume events").print()
    */

/*
    val fs: DStream[String] = flumeStream.count().map(cnt => "Flume-Received-Stream [" + cnt + "], flume events")
    fs.print();


    val lines = flumeStream.map {
      e => new String(e.event.getBody().array(), "UTF-8")
    }
*/


