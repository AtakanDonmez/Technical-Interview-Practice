package Ch01_Arrays_and_Strings;

import CtCILibrary.AssortedMethods;

public class Q03_URLify {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = arr.length;
        URLify(arr, trueLength);
        System.out.println("\"" + AssortedMethods.charArrayToString(arr) + "\"");
    }

    public static void URLify(char[] str, int trueLength) {
        int last = lastChar(str);
        int cur = last;
        int trueCur = trueLength - 1;
        while (trueCur >= 0) {
            if (str[cur] == ' ') {
                str[trueCur--] = '0';
                str[trueCur--] = '2';
                str[trueCur--] = '%';
            } else {
                str[trueCur--] = str[cur];
            }
            cur--;
        }
    }

    public static int lastChar(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') return i;
        }

        return -1;
    }
}
