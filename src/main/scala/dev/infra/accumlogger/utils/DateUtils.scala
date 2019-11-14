package dev.infra.accumlogger.utils

import org.joda.time.format.DateTimeFormat
import org.joda.time.DateTime  
import java.util.Calendar

object DateUtils {
  
  def getCurrentDate(): String = {  
   // val formatter = DateTimeFormat.forPattern("yy-MM-dd")
    val format = new java.text.SimpleDateFormat("yy-MM-dd")
    format.format(Calendar.getInstance().getTime()).toString()
  }
  
  def getCurrentHour(): String = {
    val format = new java.text.SimpleDateFormat("HH");
   format.format(Calendar.getInstance().getTime()).toString()
  }
}