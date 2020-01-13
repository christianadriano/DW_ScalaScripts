import scala.collection.mutable.HashMap 

object CountAccidentsYearCompany extends App {
     val hashMap:HashMap[String,HashMap[String,Integer]] = 
      HashMap(("2019",HashMap()),
              ("2018",HashMap()),
              ("2017",HashMap()),
              ("2016",HashMap()),
              ("2015",HashMap()),
              ("2014",HashMap()))
    
    val yearList = Array("2019","2018","2017","2016","2015","2014")
    
    val bufferedSource = io.Source.fromFile("C://Users//Christian//Desktop//JoachimsPaper//SelfDrivingCars.csv")
    for (line <- bufferedSource.getLines()) {
        val cols = line.split(",").map(_.trim)
        for (i <- 0 to cols.length){
          val words = cols(i).split(" ").map(_.trim) 
          val name = words(0)
          println(words(0))
          //val companyMap:HashMap[String,Integer] = hashMap(yearList(i))
          //if(companyMap.contains(words(0)))
           // count = companyMap(words(0)
          
        }
        // do whatever you want with the columns here
        //println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}|${cols(4)}")
    }
    bufferedSource.close
    
    
    //Count occurrences by company and year
}