package core;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class FirstTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        long n=0,p=3,q=11;

        n = p * q;//33

        //String str = "zikunov";
        String str = "severinenko";
        System.out.println();


        System.out.println(getNumbers(str));

        List<Integer> encryptedList = new ArrayList<>();
        for (Integer i: getNumbers(str))
        {
            encryptedList.add((int) modPow(i,2,n));
        }
        System.out.println(encryptedList);


    }
    private static long modPow(int a, long d, long n)
    {
        //  output = a^d mod n
        long res = 1;
        for(int i=0;i<d;i++)
        {
            res= res* a;
            res = res%n;
        }
        return res % n;
    }
    private static List<Integer> getNumbers(String str)
    {
         char[] wat = str.toCharArray();
         HashMap<String, Integer> hashMap = getMap();
         List<Integer> list = new ArrayList<>();

         for (char c:wat)
         {
            list.add(hashMap.get(String.valueOf(c)));
         }

         return list;
    }


    private static HashMap<String, Integer> getMap()
    {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("a", 1);
        hashMap.put("b", 2);
        hashMap.put("c", 3);
        hashMap.put("d", 4);
        hashMap.put("e", 5);
        hashMap.put("f", 6);
        hashMap.put("g", 7);
        hashMap.put("h", 8);
        hashMap.put("i", 9);
        hashMap.put("j", 10);
        hashMap.put("k", 11);
        hashMap.put("l", 12);
        hashMap.put("m", 13);
        hashMap.put("n", 14);
        hashMap.put("o", 15);
        hashMap.put("p", 16);
        hashMap.put("q", 17);
        hashMap.put("r", 18);
        hashMap.put("s", 19);
        hashMap.put("t", 20);
        hashMap.put("u", 21);
        hashMap.put("v", 22);
        hashMap.put("w", 23);
        hashMap.put("x", 24);
        hashMap.put("y", 25);
        hashMap.put("z", 26);
        return hashMap;
    }
}
