package core;

import stuff.RandomPrime;
import stuff.Utils;

import java.util.*;


public class Main
{
    
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		RandomPrime prime1 = new RandomPrime();
		RandomPrime prime2 = new RandomPrime();

		long n=0,p=0,q=0;

		while(p%4!=3 || q%4!=3)
		{
		      p = prime1.generatePrime();
		      q = prime2.generatePrime();

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

		for (Integer i: msgAsListOfNumbers) {
			System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
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
