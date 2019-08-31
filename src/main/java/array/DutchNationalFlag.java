package array;

import java.util.Arrays;

/*
All elements less than A[i] (the "pivot") appear first
Followed by elements equal to the pivot
Followed by elements greater than the pivot
*/

// Time: O(n)
// Space: O(1)
public class DutchNationalFlag {

    public static int[] solution(int[] arr, int pivotInd) {
        if (arr == null || pivotInd < 0 || pivotInd >= arr.length)
            return null;

        int pivot = arr[pivotInd];
        int left = 0;
        int current = 0;
        int right = arr.length - 1;
        while (current <= right) {
            if (arr[current] < pivot) {
                swap(arr, left, current);
                left++;
                current++;
            } else if (arr[current] > pivot) {
                swap(arr, current, right);
                right--;
            } else {
                current++;
            }
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("pivot 1: " + Arrays.toString(solution(new int[]{2, 1}, 1)));
        System.out.println("pivot 0: " + Arrays.toString(solution(new int[]{0, 1, 2, 0, 2, 1, 1}, 0)));
        System.out.println("pivot 1: " + Arrays.toString(solution(new int[]{0, 1, 2, 0, 2, 1, 1}, 1)));
        System.out.println("pivot 2: " + Arrays.toString(solution(new int[]{0, 1, 2, 0, 2, 1, 1}, 2)));
    }
}
