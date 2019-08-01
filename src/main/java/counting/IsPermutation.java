package counting;


/*
For example, array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
        is a permutation,

array A such that:
        A[0] = 4
        A[1] = 1
        A[2] = 3
        is not a permutation, because value 2 is missing.

        i range is [1::N]

        */
public class IsPermutation {

    static boolean solution(int[] A) {
        boolean[] arr = new boolean[A.length];
        for (int i: A) {
            if (i < 1 || i > A.length) return false;

            if (arr[i - 1]) {
                return false;
            }
            arr[i - 1] = true;
        }

        return true;
    }

    static boolean solution2(int[] A) {
        int sum = 0;
        int n = A.length;
        for (int i: A) {
            sum += i;
        }

        return n * (n + 1) / 2 == sum;
    }


    public static void main(String[] args) {
        System.out.println(solution2(new int[]{4, 1, 3, 2})); // true
        System.out.println(solution2(new int[]{4, 1, 3, 2, 5})); // true
        System.out.println(solution2(new int[]{4, 1, 3, 2, 6})); // false
        System.out.println(solution2(new int[]{4, 1, 3})); // false
    }
}
