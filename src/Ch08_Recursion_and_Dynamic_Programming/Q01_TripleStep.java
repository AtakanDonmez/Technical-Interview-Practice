package Ch08_Recursion_and_Dynamic_Programming;

import java.util.Arrays;

public class Q01_TripleStep {
    public static int countWays(int n) {
        int[] solution = new int[n+1];
        solution[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + j < n){
                    solution[i + j + 1] += solution[i];
                }
            }
        }

        return solution[n];
    }



    public static void main(String[] args) {
        int n = 20;
        int ways = countWays(n);
        System.out.println(ways);
    }
}
