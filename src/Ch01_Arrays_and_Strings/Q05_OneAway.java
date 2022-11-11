package Ch01_Arrays_and_Strings;

public class Q05_OneAway {
    public static boolean checkOA(String str1, String str2){
        int mismatch = 0;
        if (str1.length() == str2.length()){
            for (int i = 0; i < str1.length(); i++){
                if (str1.charAt(i) != str2.charAt(i)){
                    mismatch++;
                    if (mismatch > 1) return false;
                }
            }
        } else {
            int cnt1 = 0, cnt2 = 0;
            while (cnt1 < str1.length() && cnt2 < str2.length()){
                if (str1.charAt(cnt1) != str2.charAt(cnt2)){
                    mismatch++;
                    if (mismatch > 1) return false;
                    if (str1.length() > str2.length()){
                        cnt1++;
                    } else {
                        cnt2++;
                    }
                } else {
                    cnt1++;
                    cnt2++;
                }
            }
            mismatch += str1.length() + str2.length() - cnt1 - cnt2;
            if (mismatch > 1) return false;
        }

        return true;
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = checkOA(a, b);

        if (resultA == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    public static void main(String[] args) {
        String[][] tests = {{"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }

    }
}
