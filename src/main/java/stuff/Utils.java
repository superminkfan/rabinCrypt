package stuff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {
    public static List<Integer> getNumbers(String str)
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

    public static String getMsg(List<Integer> list) {
        HashMap<Integer, String> hashMap = getMapNum();
        String msg = "";
        for (Integer i : list) {
            msg = msg.concat(hashMap.get(i));
        }
        return msg;
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
    private static HashMap<Integer, String> getMapNum()
    {
        HashMap<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "a");
        hashMap.put(2, "b");
        hashMap.put(3, "c");
        hashMap.put(4, "d");
        hashMap.put(5, "e");
        hashMap.put(6, "f");
        hashMap.put(7, "g");
        hashMap.put(8, "h");
        hashMap.put(9, "i");
        hashMap.put(10, "j");
        hashMap.put(11, "k");
        hashMap.put(12, "l");
        hashMap.put(13, "m");
        hashMap.put(14, "n");
        hashMap.put(15, "o");
        hashMap.put(16, "p");
        hashMap.put(17, "q");
        hashMap.put(18, "r");
        hashMap.put(19, "s");
        hashMap.put(20, "t");
        hashMap.put(21, "u");
        hashMap.put(22, "v");
        hashMap.put(23, "w");
        hashMap.put(24, "x");
        hashMap.put(25, "y");
        hashMap.put(26, "z");

        return hashMap;
    }

    /**
     * INTEGER
     * @return  a^d mod n
     */
    public static int modPow(int a, int d, int n)
    {
        int res = 1;
        for(int i=0;i<d;i++)
        {
            res= res* a;
            res = res%n;
        }
        return res % n;
    }
}
