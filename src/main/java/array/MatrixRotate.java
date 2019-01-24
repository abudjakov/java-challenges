package array;

import java.util.Arrays;

public class MatrixRotate {

    public static void print(int[][] matrix) {
        System.out.println("---------------------");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix, int n) {
        for (int l = 0; l < n / 2; l++) {
            int start = l;
            int end = n - l - 1;
            for (int i = start; i < end; i++) {
                // top
                int top = matrix[start][i];

                // left -> top
                matrix[start][i] = matrix[end - i + start][start];

                // bottom -> left
                matrix[end - i + start][start] = matrix[end][end - i + start];

                // right -> bottom
                matrix[end][end - i + start] = matrix[i][end];

                //top -> right
                matrix[i][end] = top;
            }
        }
    }


    public static void main(String[] args) {
        int n = 5;
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        print(matrix);
        rotate(matrix, n);
        print(matrix);
        rotate(matrix, n);
        print(matrix);
    }
}
