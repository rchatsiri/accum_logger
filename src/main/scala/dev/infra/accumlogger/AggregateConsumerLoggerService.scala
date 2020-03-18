package dev.infra.accumlogger

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.spark.streaming.{Seconds, StreamingContext}
import com.typesafe.scalalogging.LazyLogging
import com.softwaremill.macwire.Module
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf

class AggregateConsumerLoggerService extends LazyLogging {
  def receiveMessageStream() {
    val sparkConf = new SparkConf().setMaster("spark://10.20.152.92:7077").setAppName("Access-Anomaly-Detect")
    val streamingContext = new StreamingContext(sparkConf, Seconds(1))
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> "10.20.152.92:9092,10.20.152.93:9092",
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> "use_a_separate_group_id_for_each_stream",
      "auto.offset.reset" -> "latest",
      "enable.auto.commit" -> (false: java.lang.Boolean))

    val topics = Array("topicA", "topicB")
    val stream = KafkaUtils.createDirectStream[String, String](
      streamingContext,
      PreferConsistent,
      Subscribe[String, String](topics, kafkaParams))

    stream.map(record => (record.key, record.value))
  }
}  