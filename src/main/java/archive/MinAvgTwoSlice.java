package archive;

public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int ind = 0;
        double min = Double.MAX_VALUE;
        boolean twoSlice = false;

        for (int i = 0; i < A.length - 1; i++) {
            double avOfTwo = (A[i] + A[i + 1]) / 2d;
            if (avOfTwo == min && !twoSlice) {
                ind = i;
                twoSlice = true;
            }
            else if (avOfTwo < min) {
                min = avOfTwo;
                ind = i;
                twoSlice = true;
            }
            if (A.length - i > 2) {
                double avOfThree = (A[i] + A[i + 1] + A[i + 2]) / 3d;
                if (avOfThree < min) {
                    min = avOfThree;
                    ind = i;
                    twoSlice = false;
                }
            }
        }

        return ind;
    }
}
