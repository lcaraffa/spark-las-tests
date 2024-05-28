import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object Main extends App {
  // Initialisation of spark session
  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("Testtouille")
    // The PDAL bindings are oly needed for use the las_reader option
    // with the "pdal" value
    //.config(
    //  "spark.executor.extraLibraryPath",
    //  "/home/MBunel/Documents/Code/Test_pdal_scala/libs/PDAL-2.5.6-src/build/lib"
    //)
    .getOrCreate();

  // Check the initialisation
  println(spark)
  println("Spark Version : " + spark.version)

  // READ Example
  val las_dataframe = spark.read
    // The option "las_reader" choose the lib for read. Two
    // values allowed "las4j" and "pdal" (slow)
    // See LAS.LASOptions for more info
    .format("IO.LAS.LAS")
    .option("las_reader", "las4j")
    .load(
      "/home/MBunel/Documents/temp/debug_chloe/Semis_2021_0486_6224_LA93_IGN69.laz"
    )

  // Check import
  las_dataframe.printSchema()
  las_dataframe.show(50)

  // Count points by class
  val count_class =
    las_dataframe
      .groupBy("Number of returns")
      .agg(count("Number of returns"))
  count_class.show()

  // Uncomment for count the lines, very long, all points are read
  // TODO: Find a way to use the "point_count" value from las's files headers
  //println(las_dataframe.count())

  // WRITE EXAMPLE
  // Write a sample in parquet (NOT in GEOparquet)
  las_dataframe.write
    .parquet(
      "/home/MBunel/Documents/temp/debug_chloe/Semis_2021_0486_6224_LA93_IGN69.parquet"
    )

}
