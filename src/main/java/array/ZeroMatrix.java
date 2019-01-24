package array;

import java.util.Arrays;

public class ZeroMatrix {

    public static void print(int[][] matrix) {
        System.out.println("---------------------");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void process(int[][] matrix) {
        boolean h = false;
        boolean v = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                v = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                h = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (h) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (v) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 1, 0, 1, 1},
                {2, 2, 2, 0, 2},
                {3, 0, 3, 3, 3},
                {4, 4, 4, 4, 4},
        };

        print(matrix);

        process(matrix);
        print(matrix);

        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {4, 0, 0, 0, 4},
        };

        assert Arrays.deepEquals(matrix, expected);

    }
}
