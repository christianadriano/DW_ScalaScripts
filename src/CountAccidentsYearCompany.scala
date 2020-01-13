import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.functions.{monotonically_increasing_id, explode, first}
import scala.collection.mutable.HashMap 
import scala.io.Source

object CountAccidentsYearCompany extends App {
	var hashMap:HashMap[String,HashMap[String,Integer]] = 
			HashMap(
			    ("2019",HashMap()),
					("2018",HashMap()),
					("2017",HashMap()),
					("2016",HashMap()),
					("2015",HashMap()),
					("2014",HashMap())
					)

			val yearList = Array("2019","2018","2017","2016","2015","2014")
      var year = "2019"
			val bufferedSource = scala.io.Source.fromFile("C://Users//Christian//Desktop//JoachimsPaper//SelfDrivingCars.csv")
			for (line <- bufferedSource.getLines()) {
				val cols = line.split(",")
						for (i <- 0 to cols.length-1){
						  year = yearList(i)
							val words = cols(i).split(" ").map(_.trim) 
							if(words!=null){
										val name = words(0).replace('"',' ').trim()
										var companyMap = hashMap(year)
										var count = 1
										if(companyMap.contains(name)){
										  count = companyMap(name)
										  count += 1
										  println(count,name,year)
										}
										companyMap.put(name,count)
										hashMap.put(year,companyMap)
							}
							else println("words null" + cols)
						}
			}
			
			println(hashMap(year))
			
bufferedSource.close

//Write results into a Spark dataframe
val DataFrame df = df.withColumn("id", (org.apache.spark.sql.functions.monotonically_increasing_id()))
  .select($"id", explode(hashMap))
  .groupBy("id")
  .pivot("key")
  .agg(first("value"))

 dataFrame.write.format("com.databricks.spark.csv").save("myFile.csv")
  
//Count occurrences by company and year
}