package array;

public class MaxSubArray {


    public static int solve(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, -2, 5})); // 9
        System.out.println(solve(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})); // 7
    }
}
