package geometry;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

import static util.ArraysPrint.print;

// time O(m x n), space O(m x n)


@Slf4j
class Array2DMaxArea {

    public static int calculate(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }

        print(matrix);
        System.out.println();
        print(height);

        int max_area = 0;
        for (int i = 0; i < m; i++) {
            max_area = Math.max(max_area, maxArea(height[i]));
            log.info("i: {}, max: {}", i, max_area);
        }

        return max_area;
    }

    private static int maxArea(int[] height) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;

        int i = 0;
        while (i < height.length) {
            if (s.empty() ||  height[i] >= height[s.peek()]) {
                s.push(i++);
                continue;
            }

            int top = s.pop();
            int h = height[top];
            int w = s.empty()
                    ? i
                    : i - s.peek() - 1;

            max_area = Math.max(h * w, max_area);
        }

        return max_area;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 1, 0},
        };

        System.out.println("Max area: " + calculate(matrix)); // 6

// matrix
//        00011
//        11110
//        01111
//        00010
// height
//        000110
//        111200
//        022310
//        000400

        int[][] matrix2 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
        };

        System.out.println("Max area: " + calculate(matrix2)); // 9
    }
}
