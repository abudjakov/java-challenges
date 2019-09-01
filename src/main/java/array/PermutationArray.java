package array;

/*
Given a collection of distinct integers, return all possible permutations.

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

https://leetcode.com/submissions/detail/256774098/

Runtime: 39 ms, faster than 5.00% of Java online submissions for Permutations.
Memory Usage: 36.8 MB, less than 97.16% of Java online submissions for Permutations.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationArray {

    public List<List<Integer>> permute(int[] nums) {
        return permutations(nums, 0, nums.length - 1, new ArrayList<>());
    }

    private List<List<Integer>> permutations(int[] arr, int l, int r, List<List<Integer>> results) {
        if (l == r) {
//            System.out.println("r: " + Arrays.toString(arr));
            results.add(IntStream.of(arr).boxed().collect(Collectors.toList()));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permutations(arr, l + 1, r, results);
                swap(arr, l, i);
            }
        }

        return results;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        PermutationArray permutationArray = new PermutationArray();
        List<List<Integer>> result = permutationArray.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
