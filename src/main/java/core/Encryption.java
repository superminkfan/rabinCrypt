package core;

import stuff.BinaryGenerator;
import stuff.DecimalGenerator;

import java.lang.*;
import java.util.ArrayList;

/**
 * This class contains methods for encryption and decryption of messages.
 * It uses modular exponentiation to encrypt and decrypt messages.
 */
class Encryption
{

	long c=0,i=0,j=0,k=0;
	long break_size;
	long n_size;
    long m_size;


	ArrayList<Integer> binArrayM;
	ArrayList<Integer> binArrayN;
	ArrayList<ArrayList<Integer>> BrokenMessage = new ArrayList<ArrayList<Integer>>();
	ArrayList<Long> finalMessage = new ArrayList<Long>();

	/**
	 * This method encrypts a message using modular exponentiation.
	 * It first converts the message to binary, then pads it with zeros if necessary.
	 * If the padded message is greater than n, it breaks the message into smaller parts and pads each part.
	 * It then encrypts each part using modular exponentiation and adds the encrypted parts to the final message.
	 *
	 * @param msg the message to encrypt
	 * @param n the modulus
	 * @return the encrypted message
	 */
	ArrayList<Long> Encrypt(long msg, long n)
	{
			BinaryGenerator binary= new BinaryGenerator();
			DecimalGenerator decimal= new DecimalGenerator();
			
			//msg
			binArrayM = binary.GenerateBinaryFormat(msg);
            binArrayM = reverse(binArrayM);
            System.out.print("Msg = "+msg);
            System.out.println("  = "+binArrayM);
     
            //padded msg
            ArrayList<Integer> padBinMsg = new ArrayList<Integer>(binArrayM);
            padBinMsg.add(0);
            padBinMsg.add(0);
            padBinMsg.add(0);
            
            //n in binary
            binArrayN = binary.GenerateBinaryFormat(n);
            binArrayN = reverse(binArrayN);
            long padMsg = decimal.getDecimal(padBinMsg);
            System.out.print("\nPadded msg = "+padMsg);
            System.out.println(" = "+padBinMsg);
            System.out.print("n = "+n );
		    System.out.println(" = "+binArrayN);
            
		    //Check if message is greater than n or smaller than n (if greater than n then break into smaller parts)
            if( padMsg < n )
        		{
            	    System.out.println("PADDED MESSAGE < N ");
        			c= (long) (Math.pow(padMsg,2)%n);
        			System.out.println("ENCRYPTED message = " + c);
        			finalMessage.add(c);
        			break_size = binArrayM.size(); //-3 because we already aded it on decryption side so it would work for both Message break and non break
        		}
        		else if( padMsg >= n )
        		{
        			System.out.println("\nPADDED MESSAGE > N : So Break Message And then Add Padding ");
                    //Normalized padding
        			n_size = binArrayN.size();
		            m_size = binArrayM.size();
		            break_size = n_size/2;
		            System.out.println("\nBreak Size = "+break_size);
		            long toadd;
		            if(m_size%break_size==0)
		            {
		            	toadd = 0;
		            }
		            else 
		            { 
		            	toadd = break_size - m_size%break_size; 
		            }
		         
		            binArrayM = reverse(binArrayM);
		            for(i=0;i<toadd;i++)
		            {
		            	binArrayM.add(0);
		            }
		            
		            ArrayList<Integer> normMsg;
		            normMsg = reverse(binArrayM);
		            System.out.println("\nNormalized size ="+normMsg);
		            
		            //breakimg data
		            int k =0;
		            long nobreaks=normMsg.size()/break_size;
		            for(long i=0; i<nobreaks ;i++)
		            {
		            	ArrayList<Integer> piece = new ArrayList<Integer>();
		            	for(long j=0; j<break_size ;j++)
		            	{
		            		piece.add(normMsg.get(k));
		            		k++;
		            	}
		            	BrokenMessage.add(piece);
		            	
		            }
		           k = 0;
		           System.out.println("\nBreaks = "+BrokenMessage);
		           for(int i=0; i<nobreaks ;i++)
		            {
		            		BrokenMessage.get(i).add(0);
		            		BrokenMessage.get(i).add(0);
		            		BrokenMessage.get(i).add(0);
		            		k++;
		            		DecimalGenerator dg = new DecimalGenerator();
		            		long c = (long) dg.getDecimal(BrokenMessage.get(i));
		            		c = (long) (Math.pow(c,2)% n);
		            		finalMessage.add(c);
		            }
		           System.out.println("\nPadded Broken Message = "+BrokenMessage);
		           System.out.println("\nEncrypted Broken Message"+finalMessage);
                    
        		}
			return finalMessage;

	}

	/**
	 * This method reverses an ArrayList.
	 *
	 * @param list the ArrayList to reverse
	 * @return the reversed ArrayList
	 */
   public static <T> ArrayList<T> reverse(ArrayList<T> list) 
     {
          int length = list.size();
          ArrayList<T> result = new ArrayList<T>(length);

          for (int i = length - 1; i >= 0; i--) 
             {
                 result.add(list.get(i));
             }
          return result;
     }

	/**
	 * This method returns the break size.
	 *
	 * @return the break size
	 */
   long getBreakSize()
   {
	   return break_size ;
   }
   

}
