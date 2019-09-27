import akka.actor.ActorSystem
import scaldi.Module
import dev.infra.accumlogger.AggregateLoggerService
import com.typesafe.config.ConfigFactory
import dev.infra.accumlogger.utils.ApplicationConf
import com.typesafe.config.Config
import scaldi.Injector
import scaldi.Module
import scaldi.Injectable._
import dev.infra.accumlogger.utils.ServiceDefine

class AkkaModule extends Module {
  bind[ActorSystem] to ActorSystem { ServiceDefine.BaseActorSystemDefine }
}

class SeedMLModule extends Module {
  binding toProvider new ApplicationConf
  binding toProvider new AggregateLoggerService
}

object ApplicaitonMain extends App {
  
  implicit val appModule = new SeedMLModule :: new AkkaModule
  val conf: Config = ConfigFactory.load()
  
  implicit val appConf = inject[ApplicationConf]
  val appName = appConf.datatumConfigConsumer(Option("app.consumer.stream.appname"))
  val sparkNode = appConf.datatumConfigConsumer(Option("app.consumer.stream.sparknode"))
  val topicName = appConf.datatumConfigConsumer(Option("app.consumer.stream.topicname"))
  val bootstrapNode = appConf.datatumConfigConsumer(Option("app.consumer.stream.bootstrap"))
  val groupId = appConf.datatumConfigConsumer(Option("app.consumer.stream.group"))
  val consumerId = appConf.datatumConfigConsumer(Option("app.consumer.stream.consumerid"))
  
  implicit val aggregateLoggerService = inject[AggregateLoggerService]
  aggregateLoggerService.receiveFlumeLogging(appName.getOrElse(""),
    sparkNode.getOrElse(""),
    topicName.getOrElse(""),
    bootstrapNode.getOrElse(""),
    groupId.getOrElse(""),
    consumerId.getOrElse(""))
   

}