import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.sql.SparkSession
class DataFrames {
  def main(args: Array[String]): Unit = {
   // disable logs
      Logger.getLogger(name = "org").setLevel(Level.OFF)
   // create spark session
    val spark = SparkSession.builder
      .master("local")
      .appName("DataFrame Demo")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
    // craete DF

    val employeeRecords = Array(
      (1,"Sarabpreet"),
      (2,"Ritakshi"),
      (3,"Nelson"),
      (4,"Saleem"),
      (5,"Promod")
    );

    val employeeDF= employeeRecords.toDF("ID","NAME");
    employeeDF.show(5)
  }
}