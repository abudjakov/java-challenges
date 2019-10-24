package array;


// Time: O(nk)
// SpaceL O(nk)
public class MaxProfitWithKTransactions {

    public static int solution(int[] prices, int k) {

        if (prices.length == 0) {
            return 0;
        }

        int[][] profit = new int[k + 1][prices.length];

        for (int t = 1; t < k + 1; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < prices.length; d++) {
                max = Math.max(max, profit[t - 1][d - 1] - prices[d - 1]);
                profit[t][d] = Math.max(profit[t][d - 1], prices[d] + max);
            }
        }
        return profit[k][prices.length - 1];
    }

    public static void main(String[] args) {
        int[] prices = {6, 10, 2, 30, 40, 80};
        System.out.println(solution(prices, 1)); // 78
        System.out.println(solution(prices, 2)); // 82
        System.out.println(solution(prices, 3)); // 82
    }

}
