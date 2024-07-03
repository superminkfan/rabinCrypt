package core;

import stuff.RandomPrime;
import stuff.Utils;

import java.util.*;

/**
 * Main class for the program.
 */
public class Main
{
    /**
     * The main method where the program execution starts.
     *
     * @param args command line arguments
     */
    public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		RandomPrime prime1 = new RandomPrime();
		RandomPrime prime2 = new RandomPrime();

		long n=0,p=0,q=0;

		/**
		 * Loop until p and q are both odd primes.
		 */
		while(p%4!=3 || q%4!=3)
		{
		      p = prime1.generatePrime();
		      q = prime2.generatePrime();

		      /**
		       * If p and q are the same, generate a new q.
		       */
		      while(p==q )
		        {
			        q = prime2.generatePrime();
		        }
		}

		n = p * q;

		System.out.println("Prime P = "+p+"\nPrime Q = "+q+"\nn = P X Q = "+n);
		System.out.println("Please Enter Your Message : ");
		String msg = scan.next();

		List<Integer> msgAsListOfNumbers = Utils.getNumbers(msg);
		List<Integer> decryptedMsg = new ArrayList<>();
		List<Long> encryptedList = new ArrayList<>();

		/**
		 * Loop through each character in the message.
		 */
		for (Integer i: msgAsListOfNumbers) {
			System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			/**
			 * Create a new Encryption object and encrypt the character.
			 */
			Encryption e = new Encryption();
			ArrayList<Long> cipher = e.Encrypt(i, n);

			//if no break messages - ok
			encryptedList.add(cipher.get(0));

			Decryption decry = new Decryption();
			decry.setValues(p, q, n, e.getBreakSize());
			decryptedMsg.add(decry.Decrypt(cipher) / 2);
		}

		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		System.out.println("Input msg = " + msg);
		System.out.println("Input list =  " + msgAsListOfNumbers);
		System.out.println("Encrypted list = " + encryptedList);
		System.out.println("Output list = " + decryptedMsg);
		System.out.println("Decrypted msg = " + Utils.getMsg(decryptedMsg));
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

   }

}
