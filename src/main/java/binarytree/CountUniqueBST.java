package binarytree;

/*
how many structurally unique BST's (binary search trees) that store values 1 ... n?
https://leetcode.com/problems/unique-binary-search-trees/

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

* */

// Dynamic Programming
public class CountUniqueBST {

//    n = 3
//    g(0) = g(1) = 0
//    g(n) = f(i, n) = g(i - 1) * g(n - i)
//    g(2) = f(i, 2) = f(1,2) + f(2,2) = g(0) * g(1) + g(1) * g(0) = 2
//    g(3) = f(i, 3) = f(1,3) + f(2,3) + f(3,3) = g(0) * g(2) + g(1) * g(1) + g(2) * g(0) = 5

// alternative
// i: 2 -> n, j: 0 -> i - 1
// catalan[i] = catalan[j] * catalan[i - j - 1]

    private static int solution(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }


    public static void main(String[] args) {
        System.out.println("for 1: " + solution(1));
        System.out.println("for 2: " + solution(2));
        System.out.println("for 3: " + solution(3));
        System.out.println("for 4: " + solution(4));
        System.out.println("for 5: " + solution(5));
        System.out.println("for 6: " + solution(6));
    }


}
