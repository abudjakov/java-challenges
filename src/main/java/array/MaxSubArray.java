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

    public static int solve2(int[] arr) {
        int max = arr[0];
        int sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], arr[i] + sum);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
//        System.out.println(solve(new int[]{1, 2, 3, -2, 5})); // 9
//        System.out.println(solve2(new int[]{1, 2, 3, -2, 5})); // 9
//        System.out.println(solve(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})); // 7
//        System.out.println(solve2(new int[]{-2, -3, 4, -1, -2, 1, 5, -3})); // 7
//        System.out.println(solve(new int[]{3, -7, 4})); // 4
//        System.out.println(solve2(new int[]{3, -7, 4})); // 4
        System.out.println(solve2(new int[]{3, -4, 8, 7, -10, 19, -3})); // 24
        System.out.println(solve2(new int[]{-8, -10, -12, -2, -3, 5})); // 5
    }
}
