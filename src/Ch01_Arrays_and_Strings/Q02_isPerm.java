package Ch01_Arrays_and_Strings;

import java.util.HashMap;

public class Q02_isPerm {
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = checkPerm(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }

    public static boolean checkPerm(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        int length = str1.length();
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();

        for (int i = 0; i < length; i++){
            if (chars.containsKey(str1.charAt(i))){
                int amount = chars.get(str1.charAt(i));
                chars.put(str1.charAt(i), amount+1);
            } else {
                chars.put(str1.charAt(i), 1);
            }
        }

        for (int i = 0; i < length; i++) {
            if (chars.containsKey(str2.charAt(i))){
                int amount = chars.get(str2.charAt(i)) -1;
                chars.put(str2.charAt(i), amount);
                if (amount < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
