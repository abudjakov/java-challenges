package array;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

https://leetcode.com/submissions/detail/256868556/

Runtime: 2 ms, faster than 95.60% of Java online submissions for Combinations.
Memory Usage: 40.7 MB, less than 36.96% of Java online submissions for Combinations.

first version of Combinations is more readable

*/

// Time: O(n * "combinations for k from n") = O(n * (n! / (k! * (n - k)!))) - combinations for k from n and each call we do O(n) work
// Space: O(k * "combinations for k from n")

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        generateCombinations(n, k, 1, candidates, combinations);
        return combinations;
    }

    private void generateCombinations(int n, int k, int offset, List<Integer> candidates, List<List<Integer>> combinations) {
        // base case - goal
        if (candidates.size() == k) {
            combinations.add(new ArrayList<>(candidates));
            return;
        }

        for (int i = offset; i <= n && n - i >= k - candidates.size(); i++) {
            // choose, explore, unchoose
            candidates.add(i);
            generateCombinations(n, k, i + 1, candidates, combinations);
            candidates.remove(candidates.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations2().combine(4, 2));
    }
}

