import com.typesafe.config.ConfigFactory
import dev.infra.accumlogger.utils.ApplicationConf
import com.typesafe.config.Config 
import dev.infra.accumlogger.utils.ServiceDefine
import dev.infra.accumlogger.AggregateConsumerLoggerService 
import dev.infra.accumlogger.AggregateHDFSLoggerService

object ApplicaitonMain extends App {
   
  val conf: Config = ConfigFactory.load()
 
   
}