from pyspark.sql import SparkSession
from pyspark.sql.functions import udf,col
def convertToTitleCase(str):
    return str.title()

if __name__ == '__main__':

    spark = SparkSession.builder.master("local").appName("DemoApp").getOrCreate()
    data = [("1","naveen n"),("2","lucky sharma")]
    df = spark.createDataFrame(data=data,schema=["id","name"])
    df.show()

    convertUDF = udf(lambda x:convertToTitleCase(x))
    df.select(convertUDF(col("name"))).show()