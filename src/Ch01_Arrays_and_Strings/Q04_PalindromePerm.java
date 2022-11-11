package Ch01_Arrays_and_Strings;

import java.util.HashMap;

public class Q04_PalindromePerm {

    public static void main(String[] args) {
        String pali = "Tact Coa";
        System.out.println(isPerm(pali));
    }

    public static boolean isPerm(String str){
        HashMap<Character, Boolean> chars = new HashMap<Character, Boolean>();
        int unmatched = 0;

        for (int i = 0; i < str.length(); i++){
            char c = Character.toLowerCase(str.charAt(i));
            if(c == ' ') continue;
            if (chars.containsKey(c)){
                if (chars.get(c) == false){
                    chars.put(c, true);
                    unmatched++;
                } else {
                    chars.put(c, false);
                    unmatched--;
                }
            } else {
                chars.put(c, true);
                unmatched++;
            }
        }

        return (unmatched < 2);
    }
}
