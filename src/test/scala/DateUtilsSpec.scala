

import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.mock.Mockito
import org.specs2.runner.JUnitRunner
import dev.infra.accumlogger.utils.DateUtils

// Ref: https://www.playframework.com/documentation/2.7.x/ScalaTestingWithSpecs2
// Simple run: sbt testOnly DateUtilsSpec
@RunWith(classOf[JUnitRunner])
class DateUtilsSpec extends Specification with Mockito {

  "Date Simple" should {
    "start date with" in {
      val date = DateUtils.getCurrentDate()
      println("Date: " + date)
      date must startingWith("19")
    }
  }
  
  "Hour Simple" should {
    "All current time in calendar" in {
      val hour = DateUtils.getCurrentHour()
      println("Hours: "+hour)
      hour must startingWith("1")
    }
  }

} 