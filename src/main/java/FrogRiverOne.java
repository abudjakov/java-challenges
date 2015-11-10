public class FrogRiverOne {

    public int solution(int X, int[] A) {
        int N = A.length;

        int sum = X * (X + 1) / 2;
        boolean[] path = new boolean[X];

        for (int i = 0; i < N; i++) {
            int pos = A[i];
            if (pos <= X && !path[pos - 1]) {
                sum -= pos;
                if (sum == 0) {
                    return i;
                }
                path[pos - 1] = true;
            }
        }

        return -1;
    };
}
