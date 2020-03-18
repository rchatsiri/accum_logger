package dev.infra.accumlogger.test
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.mock.Mockito
import org.specs2.runner.JUnitRunner  
import dev.infra.accumlogger.AggregateConsumerLoggerService
import com.softwaremill.macwire._


@RunWith(classOf[JUnitRunner])
class AggregateConsumerLoggerServiceSpec extends Specification with Mockito {
  
  
  "Simple run stream" should{
    "Single connect kafka broker" in {
      lazy val aggregateConsummerLoggerService = wire[AggregateConsumerLoggerService]
      aggregateConsummerLoggerService.receiveMessageStream()
    }
  }

} 