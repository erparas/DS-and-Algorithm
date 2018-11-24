object Sum{
  def main(args: Array[String]): Unit = {
    val in = scala.io.StdIn
    val testCase = in.readInt()
    for(k <-0 until testCase)
    {
    val n = in.readInt()
    val a = Array.ofDim[Int](n,2)
   // println("value : "+n)
    var line=""
    var minStart = Integer.MAX_VALUE
    var maxEnd = Integer.MIN_VALUE
    for (i <- 0 until n) {
         line = in.readLine()
       a(i)(0) = line.split(" ")(0).toInt
       if(minStart>a(i)(0))
				minStart=a(i)(0);
    
        a(i)(1) = line.split(" ")(1).toInt
        if(maxEnd<a(i)(1))
				maxEnd=a(i)(1);
    }
 //   println(" min : "+minStart);
//	println(" max : "+maxEnd);
	var length = maxEnd-minStart+1
    var markers = new Array[Int](length)
		
//		println(" length : "+length);
		var count =0
		
		for(ii<-0 to n-1)
		{
			for(j <-a(ii)(0) to a(ii)(1))
			{
			   // println(" i: "+ii+" , j:"+j)
				if(markers(j-minStart)==0)
				{
					markers(j-minStart)=1
					count=count+1
				}
			}
		}
		println(" count : "+count);
	
    }	
		
		
    
    //print(a(1)(0)+"value ")
  }
}
