package array;

import java.util.Arrays;

public class InsertionSort {

    public static void solution(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = k;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 9, 1, 4, 8, 2};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
