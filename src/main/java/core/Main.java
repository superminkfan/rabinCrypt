package core;

import stuff.RandomPrime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


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

		System.out.println("Prime P = "+p+"\n\nPrime Q = "+q+"\n\nn = P X Q = "+n);
		System.out.println("Please Enter Your Message : ");
		String msg = scan.next();

		List<Integer> msgAsListOfNumbers = getNumbers(msg);

		List<Integer> decryptedMsg = new ArrayList<>();
		for (Integer i: msgAsListOfNumbers) {
			System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
			Encryption e = new Encryption();
			ArrayList<Long> cipher = e.Encrypt(i, n);
			Decryption decry = new Decryption();
			decry.setValues(p, q, n, e.getBreakSize());
			decryptedMsg.add(decry.Decrypt(cipher) / 2);
		}
		System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		System.out.println("Input msg = " + msg);
		System.out.println("Input list =  " + msgAsListOfNumbers);
		System.out.println("Output list = " + decryptedMsg);

   }

	private static List<Integer> getNumbers(String str)
	{
		int[] numbers = new int[str.length()];
		for (int i = 1; i <= str.length(); i++)
		{
			int min = Integer.MAX_VALUE;
			int indexOfMin = 0;
			for (int j = 0; j < str.length(); j++)
			{
				if (numbers[j] == 0)
				{
					int c = (int)str.charAt(j);
					if (c < min)
					{
						min = c;
						indexOfMin = j;
					}
				}
			}
			numbers[indexOfMin] = i;
		}
		return Arrays.stream(numbers).boxed().toList();
	}

}
