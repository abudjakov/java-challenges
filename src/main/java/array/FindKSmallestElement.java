package array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKSmallestElement {


    public static Integer solution(Integer[] arr, int k) {
        if (k > arr.length) return null;

        return sort(arr, 0, arr.length - 1, k);
    }


    public static Integer sort(Integer[] arr, int lo, int hi, int k) {
        if (lo < hi) {
            int j = pivot(arr, lo, hi);

            if (k == j + 1) {
                return arr[j];
            }

            if (k < j + 1) {
                return sort(arr, lo, j - 1, k);
            }
            else {
                return sort(arr, j + 1, hi, k);
            }

        }

        return arr[k - 1];
    }

    public static int pivot(Integer[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Integer v = arr[lo];  // pivot

        while (true) {
            while (arr[++i].compareTo(v) <= 0) {
                if (i == hi) break;
            }

            while (arr[--j].compareTo(v) >= 0) {
                if (j == lo) break;
            }

            if (i >= j) break;

            swap(arr, i, j);
        }

        swap(arr, lo, j);

        return j;
    }

    private static void swap(Integer[] arr, int i, int j) {
        Integer tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static Integer solution2(Integer[] arr, int k) {
        if (k > arr.length) return null;

        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);

            if (queue.size() > k) {
                queue.poll();
            }
            System.out.println(queue);
        }

        return queue.poll();
    }


    public static void main(String[] args) {
        System.out.println("smallest k=1: " + solution2(new Integer[]{3, 10, 5, 8, 1, 7}, 1)); //1
        System.out.println("smallest k=2: " + solution2(new Integer[]{3, 10, 5, 8, 1, 7}, 2)); //3
        System.out.println("smallest k=3: " + solution2(new Integer[]{3, 10, 5, 8, 1, 7}, 3)); //5
        System.out.println("smallest k=4: " + solution2(new Integer[]{3, 10, 5, 8, 1, 7}, 4)); //7
        System.out.println("smallest k=10: " + solution2(new Integer[]{3, 10, 5, 8, 1, 7}, 10)); //null

    }
}
