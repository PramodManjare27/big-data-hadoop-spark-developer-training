from pyspark.sql import SparkSession, Window
from pyspark.sql.functions import *

if __name__ == '__main__':
    spark = SparkSession.builder.appName("DemoApp").master("local").config("spark.jars",
                                                                           "sqlite-jdbc-3.36.0.3.jar").getOrCreate()

    connection_url = "jdbc:sqlite:window_functions.db"
    db_properties = {"driver": "org.sqlite.JDBC"}

    employee_df = spark.read.jdbc(url=connection_url, table='employee_wf', properties=db_properties)

    employee_df.show()

    employee_df.createOrReplaceTempView("employee_wf")
    print("Window FUnctions")
    spark.sql("select *, sum(salary) OVER(PARTITION by department_id) as total_salary from employee_wf").show()

    windowSpec1 = Window.partitionBy(col("department_id"))
    employee_df.withColumn("total_salary", sum("salary").over(windowSpec1)).show()

    windowSpec2 = Window.partitionBy(col("department_id")).rowsBetween(-1, 1)
    print("--")
    employee_df.withColumn("total_salary", sum("salary").over(windowSpec2)).show()

    print("--windowSpec3--")
    windowSpec3 = Window.partitionBy(col("department_id")).rowsBetween(Window.unboundedPreceding, Window.currentRow)
    print("--")
    employee_df.withColumn("total_salary", sum("salary").over(windowSpec3)).show()

    windowSpec = Window.partitionBy(col("department_id"))
    employee_df.withColumn("total_salary", sum("salary").over(windowSpec).alias("total_salary")).withColumn(
        "percentage",round(col("salary") * 100 / col("total_salary"),2)).show()
