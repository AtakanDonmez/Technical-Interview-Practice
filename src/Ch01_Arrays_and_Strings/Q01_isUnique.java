package Ch01_Arrays_and_Strings;

import java.util.HashMap;

public class Q01_isUnique {

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUnique(word));
        }
    }

    public static boolean isUnique(String str) {
        HashMap<Character, Integer> usedChars = new HashMap<Character, Integer>();

        for (int i = 0; i < str.length(); i++) {
            if (usedChars.containsKey(str.charAt(i))) {
                return false;
            } else {
                usedChars.put(str.charAt(i), 1);
            }
        }

        return true;
    }
}
