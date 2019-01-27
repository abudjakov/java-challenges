package array;


import java.util.Arrays;


public class MergeSort {

    public static void print(String msg, String[] arr) {
        System.out.println(msg + ": " + Arrays.toString(arr));
    }

    private static void merge(String[] arr, String[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int i = lo;
        int j = mid + 1;
        for (int a = lo; a <= hi; a++) {
            if (i > mid) arr[a] = aux[j++];
            else if (j > hi) arr[a] = aux[i++];
            else if (aux[i].compareTo(aux[j]) < 0) arr[a] = aux[i++];
            else arr[a] = aux[j++];
        }
    }


    private static void sort(String[] arr, String[] aux, int lo, int hi) {
        if (lo >= hi) return;

        int mid = (lo + hi) / 2;
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    public static void sort(String[] arr) {
        String[] aux = new String[arr.length];

        sort(arr, aux, 0, arr.length - 1);
    }


    public static void main(String[] args) {
        String[] arr = new String[]{"K", "L", "A", "X", "B", "O", "E", "X", "C"};
        print("input", arr);

        String[] expected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(expected);
        print("expected", expected);

        sort(arr);
        print("result", arr);

        assert Arrays.equals(arr, expected);
    }
}
