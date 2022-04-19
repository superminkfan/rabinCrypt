package stuff;

import java.util.ArrayList;

public class BinaryGenerator {

  
    public ArrayList<Integer> GenerateBinaryFormat(long number)
    {
    	ArrayList<Integer> binary = new ArrayList();
        int bineq = 0;

        while(number > 0)
         {
          	bineq = (int)number%2;
        	binary.add((bineq));
        	number = number/2;
         }
        return binary;
        
    }
}

     
