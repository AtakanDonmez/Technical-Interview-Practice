package Ch10_Sorting_and_Searching;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;
import java.util.Comparator;

public class Q02_GroupAnagrams {
    static class AnagramComparator implements Comparator<String> {
        private String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        @Override
        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s2));
        }
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        System.out.println(AssortedMethods.stringArrayToString(array));
        Arrays.sort(array, new AnagramComparator());
        System.out.println(AssortedMethods.stringArrayToString(array));
    }
}
