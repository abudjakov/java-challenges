package counting;


import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1
*/
public class CoinChange {

    // Bottom - Up
    public static int solution(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int diff = i - coins[j];
                if (diff < 0) continue;
                memo[i] = Math.min(memo[diff] + 1, memo[i]);
            }
        }

        return memo[amount] == Integer.MIN_VALUE ? -1 : memo[amount];
    }

    // Up - Down
    public static int solution2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return solution2(coins, amount, memo);
    }

    public static int solution2(int[] coins, int remainder, int[] memo) {
        if (remainder < 0) return -1;
        if (remainder == 0) return 0;

        if (memo[remainder] != 0) {
            return memo[remainder];
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            int result = solution2(coins, remainder - coins[j], memo);
            if (result < 0) continue;
            min = Math.min(result + 1, min);
        }
        memo[remainder] = min == Integer.MAX_VALUE ? -1 : min;

        return memo[remainder];
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{1, 2, 5}, 0)); // 0
        System.out.println(solution2(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(solution2(new int[]{2, 5}, 24)); // 6
        System.out.println(solution2(new int[]{2, 3, 5}, 18)); // 4
        System.out.println(solution2(new int[]{5, 10}, 12)); // -1
        System.out.println(solution2(new int[]{2}, 3)); // -1
    }
}
