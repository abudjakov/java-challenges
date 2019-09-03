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

https://leetcode.com/submissions/detail/256863806/

Runtime: 1 ms, faster than 100.00% of Java online submissions for Combinations.
Memory Usage: 39.2 MB, less than 84.78% of Java online submissions for Combinations.

*/



// Time: O(n * "combinations for k from n") = O(n * (n! / (k! * (n - k)!))) - combinations for k from n and each call we do O(n) work
// Space: O(k * "combinations for k from n")

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        generateCombinations(n, k,  candidates, combinations);
        return combinations;
    }

    private void generateCombinations(int n, int k, List<Integer> candidates, List<List<Integer>> combinations) {
        // base case - goal
        if (k == 0) {
            combinations.add(new ArrayList<>(candidates));
            return;
        }

        if (n < k || n < 1) {
            return;
        }

        // choose, explore, unchoose
        // include
        candidates.add(n);
        generateCombinations(n - 1, k - 1, candidates, combinations);
        candidates.remove(candidates.size() - 1);
        // exclude
        generateCombinations(n - 1, k, candidates, combinations);
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
