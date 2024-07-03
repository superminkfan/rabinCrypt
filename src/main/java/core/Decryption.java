package core;

import stuff.BinaryGenerator;
import stuff.DecimalGenerator;
import stuff.ExtendedEuclid;

import java.util.ArrayList;

/**
 * Decryption class is responsible for decrypting the encrypted messages.
 * It uses the ExtendedEuclid algorithm to compute the modular multiplicative inverse of p and q.
 * It then uses these inverses to decrypt the encrypted messages.
 * The decrypted messages are then checked to ensure they are valid by comparing them to the original message.
 * If a valid message is found, it is added to a list of message pieces.
 * Finally, the Decryption class generates the complete decrypted message from the list of message pieces.
 */
class Decryption {
    private long p, q, n, invp, invq;
    private long r, s;
    private long m1, m2, m3, m4;
    private ArrayList<Long> message_pieces = new ArrayList<Long>();
    private long piece;
    private long x = 0, y = 0;
    private long i = 0, breaksize, nsize;

    /**
     * Decrypts the encrypted messages.
     *
     * @param c The encrypted messages.
     * @return The decrypted message.
     */
    int Decrypt(ArrayList<Long> c) {
        ExtendedEuclid eeuclid = new ExtendedEuclid();
        eeuclid.compute(p, q);

        invp = eeuclid.getx();
        if (invp < 0) {
            invp = q + invp;
        }
        invq = eeuclid.gety();
        if (invq < 0) {
            invq = p + invq;
        }
        System.out.println("\nEXTENDED EUCLIDEAN : invp = " + invp + " invq =" + invq);

        for (i = 0; i < c.size(); i++) {
            System.out.println("c = " + c.get((int) i) + " P+1/4 = " + ((p + 1) / 4) + " q+1/4 =" + ((q + 1) / 4));
            r = modPow(c.get((int) i), (p + 1) / 4, p);
            s = modPow(c.get((int) i), (q + 1) / 4, q);
            System.out.println("\nvalues : r = c^(p+1/4)mod p = " + r + "\n\t s = c^(q+1/4)mod q = " + s);
            x = (invp * p * s + invq * q * r) % n;
            y = (invp * p * s - invq * q * r) % n;

            //Four value possible
            m1 = x;
            if (m1 < 0) {
                m1 = n + m1;
            }
            m2 = -x % n;
            if (m2 < 0) {
                m2 = n + m2;
            }
            m3 = y;
            if (m3 < 0) {
                m3 = n + m3;
            }
            m4 = -y % n;
            if (m4 < 0) {
                m4 = n + m4;
            }
            System.out.println("Decrypted Messages : m1 = " + m1 + "  m2 = " + m2 + "  m3 = " + m3 + "  m4 = " + m4);
            BinaryGenerator binary = new BinaryGenerator();
            DecimalGenerator decimal = new DecimalGenerator();
            ArrayList<Integer> check[] = new ArrayList[4];
            // all are in reverse order
            check[0] = binary.GenerateBinaryFormat(m1);
            check[1] = binary.GenerateBinaryFormat(m2);
            check[2] = binary.GenerateBinaryFormat(m3);
            check[3] = binary.GenerateBinaryFormat(m4);

            int correct = -1, j = 0;
            for (j = 0; j < 4; j++) {
                if (check[j].size() < breaksize) {
                    while (check[j].size() != breaksize) {
                        check[j].add(0);
                    }
                }
                if (check[j].size() <= breaksize + 3) {
                    correct = check[j].get(0) + check[j].get(1) + check[j].get(2);
                    if (correct == 0) {
                        ArrayList<Integer> msg = new ArrayList<Integer>(check[j].subList(3, check[j].size()));
                        msg = reverse(msg);
                        piece = decimal.getDecimal(msg);
                        message_pieces.add(piece);
                        System.out.println("DECRYPTED MESSAGE PARTS IS : " + piece);
                        break;
                    }
                }
            }
        }
        return generateMessage(message_pieces);
    }

    /**
     * Sets the values for p, q, n, and breaksize.
     *
     * @param p The first prime number.
     * @param q The second prime number.
     * @param n The product of p and q.
     * @param breaksize The size of the break.
     */
    void setValues(long p, long q, long n, long breaksize) {
        this.p = p;
        this.q = q;
        this.n = n;
        this.breaksize = breaksize;
    }

    /**
     * Reverses the order of elements in an ArrayList.
     *
     * @param list The ArrayList to reverse.
     * @return The reversed ArrayList.
     */
    public static <T> ArrayList<T> reverse(ArrayList<T> list) {
        int length = list.size();
        ArrayList<T> result = new ArrayList<T>(length);
        for (int i = length - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }

/**
 * This method calculates the modular exponentiation of a number.
 * It returns the result of a raised to the power d modulo n.
 *
 * @param a the base number
 * @param d the exponent
 * @param n the modulus
 * @return the result of a^d mod n
 */
public long modPow(long a, long d, long n)
{
	long res = 1;
	for(int i=0;i<d;i++)
	{
		res= res* a;
		res = res%n;
	}
	return res % n;
}

/**
 * This method generates a message from an ArrayList of Long values.
 * It converts each Long value to a binary format, pads it with zeros if necessary,
 * and then adds it to the message ArrayList.
 * Finally, it converts the binary message to a decimal value and returns it.
 *
 * @param msg the ArrayList of Long values
 * @return the decimal value of the binary message
 */
int generateMessage(ArrayList<Long> msg)
{
	int i=0;
	BinaryGenerator binary1 = new BinaryGenerator();
	DecimalGenerator decimal1 = new DecimalGenerator();
	ArrayList<Integer> message = new ArrayList<Integer>();
	for(i=0;i<msg.size();i++)
	{
		 ArrayList<Integer> temp = binary1.GenerateBinaryFormat(msg.get(i));
		 if(temp.size()<breaksize)
		 {
			 while(temp.size()!=breaksize)
			 {
				 temp.add(0);
			 }
		 }
		 temp = reverse(temp);
		 message.addAll(temp);

	}
	System.out.println("Message : " + message);
	System.out.println("Message = " + (int)decimal1.getDecimal(message));
	return (int) decimal1.getDecimal(message);

}

}