package dynamic;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.


* */

import java.util.Arrays;

// Time O(N^2), Space O(N)
public class LongestIncreasingSubsequenceLength {

    public static int solution(int[] arr) {
        int[] maxLength = new int[arr.length];
        Arrays.fill(maxLength, 1);

        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
                }
            }
            max = Math.max(max, maxLength[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4 [2,3,7,101],
        System.out.println(solution(new int[]{3, 4, -1, 5, 8, 2, 3, 12, 7, 9, 10})); // 6 [-1, 2, 3, 7, 9, 10]
        System.out.println(solution(new int[]{-1, 2, 1, 3, 0, 5})); // 4 [-1, 2, 0, 5]
    }
}
