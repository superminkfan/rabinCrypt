package core;

import stuff.ExtendedEuclid;
import stuff.RandomPrime;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class FirstTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        int p= 3,q = 11,n;
        long a, b;
        Scanner scan = new Scanner(System.in);

        n = p * q;

        System.out.println("Prime P = "+p+"\nPrime Q = "+q+"\nn = P X Q = "+n);
        System.out.println("Please Enter Your Message : ");
        String str = scan.next();

        n = p * q;

        System.out.println("Msg as list = " + Utils.getNumbers(str));

        List<Integer> encryptedList = new ArrayList<>();
        for (Integer i: Utils.getNumbers(str))
        {
            encryptedList.add(Utils.modPow(i,2,n));
        }
        System.out.println("Encrypted list = " + encryptedList);
        int size = encryptedList.size();


        ExtendedEuclid euclid = new ExtendedEuclid();
        euclid.compute(p, q);
        a = euclid.getx();
        b = euclid.gety();


        List<Integer> rList = new ArrayList<>();
        for (Integer i: encryptedList)
        {
            rList.add(Utils.modPow(i, (p+1)/4, p));
        }
        System.out.println("r = " + rList);

        List<Integer> sList = new ArrayList<>();
        for (Integer i: encryptedList)
        {
            sList.add(Utils.modPow(i, (q+1)/4, q));
        }
        System.out.println("s = " + sList);

        List<Integer> x1List = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            x1List.add(((int)a * p * sList.get(i) + (int)b * q * rList.get(i)) % n);
        }
        System.out.println("x1 = " + x1List);

        List<Integer> x2List = new ArrayList<>();
        for (Integer i: x1List)
        {
            x2List.add(n - i);
        }

        System.out.println("x2 = " + x2List);

        List<Integer> y1List = new ArrayList<>();
        for (int i = 0; i < size; i++)
        {
            y1List.add(((int)a * p * sList.get(i) - (int)b * q * rList.get(i)) % n);
        }
        System.out.println("y1 = " + y1List);

        List<Integer> y2List = new ArrayList<>();
        for (Integer i: y1List)
        {
            y2List.add(n - i);
        }

        System.out.println("y2 = " + y2List);


        System.out.println(Utils.getMsg(x1List));
        System.out.println(Utils.getMsg(x2List));
        System.out.println(Utils.getMsg(y1List));
        System.out.println(Utils.getMsg(y2List));


    }

}
