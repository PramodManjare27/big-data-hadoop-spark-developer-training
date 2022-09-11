package org.simplilear.hands_on

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession

object _01CreateDataFrameFromCollection {
  def main(args: Array[String]): Unit = {
    // Step 01
    Logger.getLogger("org")
          .setLevel(Level
            .OFF)
    // Step 02
    val spark = SparkSession.builder()
                            .appName("DemoApp")
                            .master("local")
                            .getOrCreate()

    val userRecords = Array((1,"Naveen"),(2,"Lucky"))

    val userDF = spark.createDataFrame(userRecords)

    userDF.show()
  }
}
