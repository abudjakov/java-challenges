import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        return Math.max(A[0] * A[1] * A[N - 1], A[N - 1] * A[N - 2] * A[N - 3]);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProductOfThree().solution(new int[]{-5, 5, -5, 4}));
    }
}
