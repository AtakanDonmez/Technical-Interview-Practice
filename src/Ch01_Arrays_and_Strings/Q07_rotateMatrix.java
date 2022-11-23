package Ch01_Arrays_and_Strings;
import CtCILibrary.AssortedMethods;

import java.lang.Math;

public class Q07_rotateMatrix {
    public static boolean rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int i = 0; i < Math.floorDiv(n,2); i++){
            for (int j = 0; j < Math.ceilDiv(n,2); j++){
                // 1
                int cur = matrix[i][j];
                int next = matrix[n-1-j][i];
                matrix[n-1-j][i] = cur;

                // 2
                cur = next;
                next = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = cur;

                // 3
                cur = next;
                next = matrix[j][n-1-i];
                matrix[j][n-1-i] = cur;

                // 4
                cur = next;
                matrix[i][j] = cur;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(5, 5, 0, 25);
        AssortedMethods.printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }
}
