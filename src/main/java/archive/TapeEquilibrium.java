package archive;

public class TapeEquilibrium {

    public int solution(int[] A) {
        int n = A.length;
        int min = 0;
        int[] sum = prefixSums(A);
        for (int i = 1; i < n; i++) {
            int leftSum = sum[i];
            int rightSum = sum[n] - sum[i];
            int diff = Math.abs(leftSum - rightSum);
            if (diff < min || min == 0)
                min = diff;
        }

        return min;
    };

    private int[] prefixSums(int[] A) {
        int n = A.length;
        int[] sum = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        return sum;
    }
}
