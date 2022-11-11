package Ch01_Arrays_and_Strings;

import java.util.ArrayList;

public class Q06_StringCompression {
    public static void main(String[] args){
        String str = "aaaaabbbbaaaabbddc";
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) compress(str);
        long time2 = System.currentTimeMillis();
        System.out.println(compress(str));
        System.out.println(time2 - time1);

        time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) compress2(str);
        time2 = System.currentTimeMillis();
        System.out.println(compress2(str));
        System.out.println(time2 - time1);
    }

    public static String compress(String str){
        ArrayList<Character> chars = new ArrayList<Character>();
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 1;
            while (i+1 < str.length() && str.charAt(i + 1) == c){
                i++;
                count++;
            }

            chars.add(c);
            nums.add(count);
        }

        if (chars.size() * 2 >= str.length()) return str;

        String compressedStr = "";
        for (int i = 0; i < chars.size(); i++) {
            compressedStr += chars.get(i);
            compressedStr += nums.get(i);
        }

        return compressedStr;
    }

    public static String compress2(String str){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int count = 1;
            while (i+1 < str.length() && str.charAt(i + 1) == c){
                i++;
                count++;
            }

            sb.append(c);
            sb.append(count);
        }

        if (sb.length() >= str.length()) return str;

        return sb.toString();
    }
}
