package dynamic;

/*
Given an unsorted array of integers, find the longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: [2,3,7,101]

* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time O(N logN), Space O(N)
public class LongestIncreasingSubsequence {

    public static List<Integer> solution(int[] arr) {
        int[] temp = new int[arr.length];
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        int len = 0;
        temp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[temp[len]]) {
                result[i] = temp[len];
                temp[++len] = i;
            } else if (arr[i] < arr[temp[0]]) {
                temp[0] = i;
            } else {
                int ind = cellIndex(arr, temp, len + 1, arr[i]);
                temp[ind] = i;
                result[i] = temp[ind - 1];
            }
        }

//        System.out.println("lcs length: " + (len + 1));
//        System.out.println("temp: " + Arrays.toString(temp));
//        System.out.println("result: " + Arrays.toString(result));
        List<Integer> lcs = new ArrayList<>();
        int ind = temp[len];
        while (ind != -1) {
            lcs.add(0, arr[ind]);
            ind = result[ind];
        }

        return lcs;
    }

    private static int cellIndex(int[] arr, int[] temp, int len, int key) {
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            sorted[i] = arr[temp[i]];
        }

        int ind = Arrays.binarySearch(sorted, key);
        return ind >= 0 ? ind : -ind - 1;
    }

    public static void main(String[] args) {
        System.out.println("lcs is: " + solution(new int[]{3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10})); // [-1, 2, 3, 7, 9, 10]
        System.out.println("lcs is: " + solution(new int[]{-1, 2, 1, 3, 0, 5})); // [-1, 1, 3, 5]
        System.out.println("lcs is: " + solution(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // [2, 3, 7, 18]
    }
}
