package dynamic;


public class CoinChangeCombinations {

    // different permutations
    public static int number_of_ways_to_pay_change(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int diff = i - coins[j];
                if (diff < 0) continue;
                memo[i] += memo[diff];
            }
        }

        return memo[amount];
    }

    // order doesn't matter
    public static int number_of_ways_to_make_change(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;

        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                int diff = i - coins[j];
                if (diff < 0) continue;
                memo[i] += memo[diff];
            }
        }

        return memo[amount];
    }

    public static void main(String[] args) {
//        System.out.println(number_of_ways_to_pay_change(new int[]{1, 2}, 3)); // 3 [1, 2][2, 1][1, 1, 1]
        System.out.println(number_of_ways_to_pay_change(new int[]{1, 2}, 4)); // 5 [2, 2][2, 1, 1][1, 2, 1][1, 1, 2][1, 1, 1, 1]
//        System.out.println(number_of_ways_to_make_change(new int[]{1, 2}, 3)); // 2 [1, 1, 1][2, 1]
//        System.out.println(number_of_ways_to_make_change(new int[]{1, 2}, 4)); // 3 [1, 1, 1, 1][2, 2][1, 1, 2]
    }
}
