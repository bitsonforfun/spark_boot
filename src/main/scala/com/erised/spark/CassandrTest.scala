package com.erised.spark

import org.apache.spark.sql.SparkSession

object CassandrTest {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("ErisedSparkApp")
      .master("local[2]")
      .getOrCreate()

    val df = spark.read.json("file:///Users/bitsonli/app/data/people.json")
    df.printSchema()
    df.show()

    spark.stop()

    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._
  }
}
