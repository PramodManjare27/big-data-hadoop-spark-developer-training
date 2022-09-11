from pyspark.sql import SparkSession

if __name__ == '__main__':

    spark = SparkSession.builder.master("local").appName("DemoApp").getOrCreate()

    data = [(1,"Naveen"),(2,"Lucky")]
    columns = ["id","name"]

    df = spark.createDataFrame(data).toDF(*columns)

    df.show()

