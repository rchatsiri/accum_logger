import com.typesafe.config.ConfigFactory
import dev.infra.accumlogger.utils.ApplicationConf
import com.typesafe.config.Config 
import dev.infra.accumlogger.utils.ServiceDefine
import dev.infra.accumlogger.AggregateConsumerLoggerService  
import com.softwaremill.macwire._

object ApplicaitonMain extends App {
   
  val conf: Config = ConfigFactory.load()
  val aggregateConsumerLoggerService = wire[AggregateConsumerLoggerService]
  aggregateConsumerLoggerService.receiveMessageStream()
   
}