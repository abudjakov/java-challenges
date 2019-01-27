package array;


import java.util.Arrays;


/*
 * left <= Pivot <= right
 * */
public class QuickSort {

    public static void print(String msg, String[] arr) {
        System.out.println(msg + ": " + Arrays.toString(arr));
    }

    public static int partition(String[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        String v = arr[lo];  // pivot

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

    private static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void sort(String[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"K", "L", "A", "X", "B", "O", "E", "X", "C"};
        print("input", arr);

        String[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        print("expected", expected);

        sort(arr, 0, arr.length - 1);
        print("result", arr);

        assert Arrays.equals(arr, expected);
    }
}
