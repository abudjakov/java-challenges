package array;

public class MaxProductSubArray {

    public static int solve(int[] arr) {
        int min;
        int max;

        min = max = arr[0];
        int result = arr[0];

        System.out.println(String.format("%3s min = %3s max = %3s", arr[0], min, max));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                min = Math.min(arr[i], min * arr[i]);
                max = Math.max(arr[i], max * arr[i]);
            } else {
                int tmp = min;
                min = Math.min(arr[i], max * arr[i]);
                max = Math.max(arr[i], tmp * arr[i]);
            }
            System.out.println(String.format("%3s min = %3s max = %3s", arr[i], min, max));

            result = Math.max(result, max);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(solve(new int[]{2, 3, -2, 4})); // 6
        System.out.println(solve(new int[]{2, 3, -2, 4, 2})); // 8
        System.out.println(solve(new int[]{2, 3, -2, 4, 2, -1})); // 96
    }
}
