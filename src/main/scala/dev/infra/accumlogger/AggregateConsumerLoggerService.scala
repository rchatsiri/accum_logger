package dev.infra.accumlogger

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import com.typesafe.scalalogging.LazyLogging
import com.softwaremill.macwire.Module

@Module
object AggregateConsumerLoggerService extends LazyLogging{
  
}  