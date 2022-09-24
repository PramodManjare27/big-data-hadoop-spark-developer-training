import org.apache.log4j.{Level, Logger}
import org.apache.spark
import org.apache.spark.sql.SparkSession

val spark1 = SparkSession.builder
  .master("local")
  .appName("DataFrame Demo")
  .config("spark.some.config.option", "some-value")
  .getOrCreate();

    val employeeRecords = Array(
      (1,"Sarabpreet"),
      (2,"Ritakshi"),
      (3,"Nelson"),
      (4,"Saleem"),
      (5,"Promod")
    );

    val employeeDF= spark1.createDataFrame(employeeRecords)
    employeeDF.show(5)
