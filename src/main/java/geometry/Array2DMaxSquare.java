package geometry;

import util.ArraysPrint;

import java.util.Arrays;

/**

 Maximum square of 2D matrix filled by 1

 [[0, 1, 1, 0, 1],
 [1, 1, 0, 1, 0],
 [0, 1, 1, 1, 0],
 [1, 1, 1, 1, 0],
 [1, 1, 1, 1, 1],
 [0, 0, 0, 0, 0]]

 -->

 0  1  1  0  1
 1  1  0  1  0
 0  1  1  1  0
 1  1  2  2  0
 1  2  2  3  1
 0  0  0  0  0

 -->

 9

 */

public class Array2DMaxSquare {

    public static int calculate(int[][] matrix) {
        int r = matrix.length;
        int c = r == 0 ? 0 : matrix[0].length;

        int[][] arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            arr[i][0] = matrix[i][0];
        }
        for (int i = 0; i < c; i++) {
            arr[0][i] = matrix[0][i];
        }

        int max = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) continue;
                int min = Math.min(arr[i][j - 1], Math.min(arr[i - 1][j], arr[i - 1][j - 1]));
                arr[i][j] = min + 1;
                max = Math.max(max, arr[i][j]);
            }
        }
        ArraysPrint.print(arr);

        return max * max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };

        System.out.println("Max area: " + calculate(matrix)); // 9
    }
}
