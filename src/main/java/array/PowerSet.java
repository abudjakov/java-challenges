package array;


/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

https://leetcode.com/submissions/detail/256833480/

Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
Memory Usage: 37.2 MB, less than 99.18% of Java online submissions for Subsets.


*/

import java.util.ArrayList;
import java.util.List;

// Time: O(n * (2^n)) - There are 2^n subsets of any overarching set
// Space: O(n * (2^n))
public class PowerSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        generatePowerset(nums, 0, candidates, powerset);
        return powerset;
    }

    private void generatePowerset(int[] nums, int decisionPoint, List<Integer> candidates, List<List<Integer>> powerset) {
        // base case - goal
        if (decisionPoint == nums.length) {
            powerset.add(new ArrayList<>(candidates));
            return;
        }

        // choose, explore, unchoose
        // include
        candidates.add(nums[decisionPoint]);
        generatePowerset(nums, decisionPoint + 1, candidates, powerset);
        candidates.remove(candidates.size() - 1);
        // exclude
        generatePowerset(nums, decisionPoint + 1, candidates, powerset);
    }

    public static void main(String[] args) {
        System.out.println(new PowerSet().subsets(new int[]{1, 2, 3}));
    }
}
