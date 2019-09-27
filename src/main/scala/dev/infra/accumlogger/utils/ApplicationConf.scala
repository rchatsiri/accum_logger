package dev.infra.accumlogger.utils

import com.typesafe.config.ConfigFactory

class ApplicationConf {
  
    val conf = ConfigFactory.load();
    def datatumConfigConsumer(loggingPath:  Option[String] = None) : Option[String] = {
            val path  = conf.getString(loggingPath.getOrElse("default"))
            Option(path)
    }
}