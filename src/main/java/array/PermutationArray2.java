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

https://leetcode.com/submissions/detail/256814634/

Runtime: 1 ms, faster than 97.80% of Java online submissions for Permutations.
Memory Usage: 37.6 MB, less than 95.04% of Java online submissions for Permutations.

*/

// Time: O(n * n!) - n! permutations and it takes O(n) time to add each one to results
// Space: O(n * n!) - n! permutations and each permutation have length n


import java.util.ArrayList;
import java.util.List;

public class PermutationArray2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        return permutations(nums, candidates, results);
    }

    private List<List<Integer>> permutations(int[] arr, List<Integer> candidates, List<List<Integer>> results) {
        // base case - goal
        if (candidates.size() == arr.length) {
            results.add(new ArrayList<>(candidates));
        } else {
            for (int i = 0; i < arr.length; i++) {
                // constraints
                if (candidates.contains(arr[i])) {
                    continue;
                }

                // choose, explore, unchoose
                candidates.add(arr[i]);
                permutations(arr, candidates, results);
                candidates.remove(candidates.size() - 1);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        PermutationArray2 permutationArray = new PermutationArray2();
        List<List<Integer>> result = permutationArray.permute(new int[]{1, 2, 3});
        System.out.println(result);
    }
}
