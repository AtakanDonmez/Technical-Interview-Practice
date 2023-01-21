package Ch10_Sorting_and_Searching;

import java.util.Comparator;
import java.util.List;

public class AncestralNames {
    /*
     Roman -> Decimal Converter:
     Iterate over the string
     Check if rem = x % charValue > 0:
        x - 2*rem + charValue
     else:
        Add value of char to integer x

     sortRoman:
     Create a comparator:
        split the string into name and number
        compare name1 name2
        if comparison is equal:
            compare number1 number2

     sort with the new comparator
     */

    public static List<String> sortRoman(List<String> names) {
        Comparator<String> byRoman = (o1, o2) -> {
            String[] split1 = o1.split("\\s");
            String[] split2 = o2.split("\\s");

            // compare name1 to name2
            int comparison = split1[0].compareTo(split2[0]);
            if(comparison == 0){
                return romanToDec(split1[1]) - romanToDec(split2[1]);
            }

            return comparison;
        };
        names.sort(byRoman);
        return names;

    }

    public static int romanToDec(String str){
        int value = 0;
        int len = str.length();
        char[] chars = str.toCharArray();
        for(int i = 0; i < len; i++){
            int charValue = switch (chars[i]) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                default -> 0;
            };

            int rem = value % charValue;
            if(rem > 0){
                value = value - (2 * rem) + charValue;
            } else {
                value += charValue;
            }
        }

        return value;
    }
}
