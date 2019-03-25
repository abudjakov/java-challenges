package matrix;

public class LeftmostColumn {


    public static int solve(int[][] matrix) {
        if (matrix.length == 0) {
            return -1;
        }

        int leftmost = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int c = 0;
            while (c < leftmost) {
                if (matrix[i][c] == 1) {
                    leftmost = c;
                    break;
                }
                c++;
            }
            if (leftmost == 0) break;
        }

        return leftmost;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
        };

        System.out.println(solve(matrix));
    }
}
