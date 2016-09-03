import scala.io.Source._
import java.io._
import scala.collection.immutable._
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.math._
import java.lang._



object KMD {
      var raw_Data = "["
      var htmldata = ""
			def main(args: Array[String]) 
			{
				var description = ""
						var filename = "/home/harish/Temp/FD.csv"
						//val fw = new FileWriter("/home/harish/Temp/ht.html", true) ;
						var basic = "Test"
						var html1 = "<h1 style='width:1000px; text-align: center; margin-bottom: 0'>A more complex Sankey Diagram</h1>" + "\n"
								var html2 = "<div style='width:1000px; text-align: center; margin-top: 0'>Move your mouse over the diagram to show values</div>" + "\n"
										var html3 = "<div id='sankey' style="+'"'+"width:1000px;height:1000px"+'"'+">" + "\n"
												var html4 = "&nbsp;"+ "</div>" + "\n" + "</body>" + "\n" + "</html>"     
						var temp_html = "</script> \n" + html1 + html2 + html3 + html4						

         //fw.write("var sankey = new Sankey();" + "\n" +) ;
         //fw.close()
         var i = 1
         var n = 1
         for (wordList <- Source.fromFile(filename).getLines()) // Iterating over the list files  
         {
        	 var cd = wordList.split(",")
        			 var n = cd.length
        			 if(i ==1)
        			 {
        				 for ( temp <- 0 until n-1)
        				 {
        					 var temp_writer = new FileWriter("/home/harish/Temp/Temp2/" + temp +".csv",true)
        					 var unq_writer = new FileWriter("/home/harish/Temp/Unq/" + temp +".csv",true)
        					 temp_writer.close()
        				 }
        			 }  
        	 for (temp1 <- 0 until n-1)
        	 {
        		 wordListFin(cd(temp1) + "_"+ cd(temp1+1),temp1)
        		 uniqueList(cd(temp1),temp1)
        	 }
        	 var fw = new FileWriter("/home/harish/Temp/Unq/"+(n-1)+".csv",true) ;
        	 fw.write(cd(n-1) +"\n")
        	 fw.close()
        	 i = i +1
         }

				var file_Sankey0 = "/home/harish/Temp/Unq/0.csv"
						val subString = ArrayBuffer[String]() 
						var y = 0
						val lines1 = (Source.fromFile(file_Sankey0, "latin1").mkString).split("\n")
						for (unqTemp0 <- 0 until lines1.length)   
						{
							var word = lines1(unqTemp0)
									subString += word
									y = y+1
						}
				var er = subString.groupBy (identity).mapValues(_.size)
				var writer2 = new PrintWriter(new File("/home/harish/Temp/Unq/Freq/temp_freq.csv")) // Creating to write to append the word frequencies
				var rx = 0
				var sumx = 0
				er.keys.foreach{ rx =>  
				writer2.write(rx +"," + er(rx) +"\r\n")
				sumx = sumx + er(rx)
				}
				writer2.close()
				val lines_Sankey0 = (Source.fromFile("/home/harish/Temp/Unq/Freq/temp_freq.csv", "latin1").mkString).split("\n")
				var sankey0 = "sankey.stack(0,["
				for (unqTemp1 <- 0 until lines_Sankey0.length)   
				{
					var temp_Sankey = sankey0 + '"'+ (lines_Sankey0(unqTemp1).split(","))(0) + '"' + ","
							sankey0 = temp_Sankey
							y = y+1
				}
				var final_Sankey0 = sankey0.dropRight(1) +"]);"  
						println(final_Sankey0)
						var filename1 = "/home/harish/Temp/Temp2/"

						var filenameList = new File(filename1).list  // Extracting the file names
						val fileCount = filenameList.length
						var sankeyX_Temp = ""
						for (x <- 0 until fileCount) // Iterating over the list of Transitions
						{ 
							val targetfile = filename1 + filenameList(x) //  retrieving a particular file
									var SankyX =  sankeyX_Temp + "\n"+ createTransitionList(targetfile, x)
									sankeyX_Temp = SankyX
						}
				//println(raw_Data)
				//println(sankeyX_Temp)
				
				htmldata =  "var raw_data =" +  raw_Data.dropRight(1) +"];"+"\n"  + final_Sankey0 +  "\n" + sankeyX_Temp + "\n" +  "sankey.setData(raw_data); \n       sankey.draw(); \n });"  + "\n" + temp_html
				println(htmldata)
				
				var htmlWrite = new FileWriter("/home/harish/Temp/ht.html",true) ;
				htmlWrite.write(htmldata)
				htmlWrite.close()
			}

			def  wordListFin ( i: String, temp1: Int) {
				var fw = new FileWriter("/home/harish/Temp/Temp2/"+temp1+".csv",true) ;
				fw.write(i+"\n")  
				fw.close()
			}
			def  uniqueList ( i: String, temp1: Int) {
				var fw = new FileWriter("/home/harish/Temp/Unq/"+temp1+".csv",true) ;
				fw.write(i+"\n")
				fw.close()
			}  

			def createTransitionList(targetfile: String, x: Int): String = 
			{
			  val subString = ArrayBuffer[String]() 
				val lines1 = (Source.fromFile(targetfile, "latin1").mkString).split("\n")
				var y = 0
						for (unqTemp0 <- 0 until lines1.length)   
						{
							var word = lines1(unqTemp0)
									subString += word
									y = y+1
						}
				var er = subString.groupBy (identity).mapValues(_.size)
				var writer2 = new PrintWriter(new File("/home/harish/Temp/Unq/Freq/temp_freq"+x+".csv")) // Creating to write to append the word frequencies
				var rx = 0
				var sumx = 0
				er.keys.foreach{ rx =>  
				writer2.write(rx +"," + er(rx) +"\r\n")
				sumx = sumx + er(rx)
				}
				writer2.close()
				val lines_SankeyX = (Source.fromFile("/home/harish/Temp/Unq/Freq/temp_freq"+x+".csv", "latin1").mkString).split("\n")
				var sankeyX = ""
				for (unqTemp1 <- 0 until lines_SankeyX.length)   
				{
				  var temp_lSankey = lines_SankeyX(unqTemp1).split(",")
				  

					var temp_fSankey = (temp_lSankey(1).replace("\n",""))
					var temp_CSankey = temp_lSankey(0)
					var temp_CLusters = temp_CSankey.split("_")
					var t_Data = "[" + '"'+ temp_CLusters(0) + '"' + "," + temp_fSankey + "," + '"'+ temp_CLusters(1) + '"' +  "],"

					var temp_rawData = raw_Data + t_Data
					
					raw_Data = temp_rawData
					
				  var temp_Sankey = sankeyX + "sankey.stack("+(x+1)+",[" + '"' + temp_CLusters(1) +'"' + "]," + '"' + temp_CLusters(0) + '"' + ");"
							  
							sankeyX = temp_Sankey +  "\n" 
							y = y+1
				}
				  
						return sankeyX

			}

}