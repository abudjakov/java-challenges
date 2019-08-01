package prefixsum;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*

A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A

find the starting position of a slice whose average is minimal

https://app.codility.com/demo/results/trainingH6VMM2-UR2/
 */
public class MinAvgTwoSlice {

    public static int solution(int[] arr) {

        if (arr.length < 2) return -1;

        int pos = 0;
        double minavg = Double.MAX_VALUE;
        double avg = 0;
        int[] slice = null;
        for (int i = 0; i < arr.length - 1; i++) {
            avg = (arr[i] + arr[i + 1]) / 2.0d;
            if (avg < minavg) {
                minavg = avg;
                pos = i;
                slice = new int[]{arr[i],arr[i + 1]};
            }
            if (i < arr.length - 2) {
                avg = (arr[i] + arr[i + 1] + arr[i + 2]) / 3.0d;
                if (avg < minavg) {
                    minavg = avg;
                    pos = i;
                    slice = new int[]{arr[i],arr[i + 1],arr[i + 2]};
                }
            }
        }

        System.out.println("slice = " + Arrays.toString(slice) + " minavg = " +  minavg);
        return pos;
    }


    public static void main(String[] args) {
        System.out.println("starting position is: " + solution(new int[]{4, 2, 2, 5, 1, 5, 8})); // 1
        System.out.println("starting position is: " + solution(new int[]{10, 10, -1, 2, 4, -1, 2, -1}));  // 5
        System.out.println("starting position is: " + solution(new int[]{1, 2, 1, 2, 1}));

    }
}
