package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingNumber {


    public static int solution(int[] array) {
        int[] sum = new int[array.length];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = array[i];
        }

        int[] sequence = new int[array.length];
        Arrays.fill(sequence, -1);

        int maxInd = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && sum[j] + array[i] > sum[i]) {
                    sum[i] = sum[j] + array[i];
                    sequence[i] = j;
                }
            }
            if (sum[i] > sum[maxInd]) {
                maxInd = i;
            }
        }

        System.out.println("sum: " + Arrays.toString(sum));
        System.out.println("sequence: " + Arrays.toString(sequence));

        List<Integer> stack = new ArrayList<>();
        int ind = maxInd;
        while (ind != -1) {
            stack.add(0, array[ind]);
            ind = sequence[ind];
        }

        System.out.println("stack: " + stack);
        return sum[maxInd];
    }



    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 70, 20, 30, 50, 11, 30}));
    }
}
