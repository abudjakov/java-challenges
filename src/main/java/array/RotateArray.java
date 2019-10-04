package array;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            rotateByOne(arr);
        }
    }

    private static void rotateByOne(int[] arr) {
        int tmp = arr[0];
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("original: " + Arrays.toString(arr));
        rotate(arr, 2);
        System.out.println("rotated: " + Arrays.toString(arr));
    }
}
