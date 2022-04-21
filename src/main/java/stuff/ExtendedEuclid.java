package stuff;

public class ExtendedEuclid
{
     long res_x,res_y;
	
     public void compute(long a, long b)
	    {
	        long x = 0, y = 1;
	        long prevx = 1, prevy = 0, temp;
	        while (b != 0)
	        {
	            long q = a / b;
	            long r = a % b;
	            a = b;
	            b = r;
	 
	            temp = x;
	            x = prevx - q * x;
	            prevx = temp;
	 
	            temp = y;
	            y = prevy - q * y;
	            prevy = temp;            
	        }
	        System.out.println("Roots  a : "+ prevx +" b :"+ prevy);
	        res_x = prevx;
	        res_y = prevy;
	        
	    }
     public long getx()
     {
    	 return res_x;
     }
     public long gety()
     {
    	 return res_y;
     }

}
