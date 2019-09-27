package dev.infra.accumlogger


import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.kafka010.OffsetRange
import org.apache.spark.streaming.kafka010.HasOffsetRanges
import org.apache.spark.TaskContext
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.ConsumerStrategies
import org.apache.spark.streaming.kafka010.PreferConsistent
import com.typesafe.scalalogging.LazyLogging
import org.slf4j.Marker
import org.apache.spark.streaming.Minutes
import org.apache.spark.streaming.kafka010.CanCommitOffsets
import org.apache.spark.sql.SparkSession
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.spark.rdd.RDD
import java.util.regex.Pattern
import org.apache.spark.streaming.flume._

class AggregateLoggerService extends LazyLogging {

  def receiveFlumeLogging(appName: String, sparkNode: String, topicName: String, bootstrapNode: String, groupId: String, consumerId: String): Unit = {
    val conf = new SparkConf().setMaster(sparkNode).setAppName(appName)
    val ssc = new StreamingContext(conf, Seconds(30))
    val flumeStream = FlumeUtils.createStream(ssc, "localhost", 9988)

    flumeStream.count().map(cnt => "Received " + cnt + " flume events.").print()

    val lines = flumeStream.map {
      e => new String(e.event.getBody().array(), "UTF-8")
    }

    ssc.start()
    ssc.awaitTermination();
  }

}





