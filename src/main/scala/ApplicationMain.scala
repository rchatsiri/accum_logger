import com.typesafe.config.ConfigFactory
import dev.infra.accumlogger.utils.ApplicationConf
import com.typesafe.config.Config 
import dev.infra.accumlogger.utils.ServiceDefine
import dev.infra.accumlogger.AggregateConsumerLoggerService 
import dev.infra.accumlogger.AggregateHDFSLoggerService

object ApplicaitonMain extends App {
  
  /* implicit val appModule = new SeedMLModule :: new AkkaModule */
  val conf: Config = ConfigFactory.load()
   
}