package array;

public class FindElementInRotatedArray {

    public static int index(int[] arr, int e) {
        return index(arr, e, 0, arr.length - 1);
    }

    private static int index(int[] arr, int e, int l, int r) {
        if (l > r)
            return -1;

        int m = (l + r) / 2;
        if (arr[m] == e) {
            return m;
        }

        // left part sorted
        if (arr[l] < arr[m]) {
            if (arr[l] <= e && e < arr[m]) {
                return index(arr, e, l, m - 1);
            }
            else {
                return index(arr, e, m + 1, r);
            }
        }
        // right part sorted
        else {
            if (arr[m] < e && e <= arr[r]) {
                return index(arr, e, m + 1, r);
            }
            else {
                return index(arr, e, l, m - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("index: " + index(new int[] {3, 4, 5, 6, 7, 8, 1, 2}, 9)); // -1
        System.out.println("index: " + index(new int[] {3, 4, 5, 6, 7, 8, 1, 2}, 6)); // 3
        System.out.println("index: " + index(new int[] {3, 4, 5, 6, 7, 8, 1, 2}, 1)); // 6
        System.out.println("index: " + index(new int[] {3, 4, 5, 6, 7, 8, 1, 2}, 2)); // 7
        System.out.println("index: " + index(new int[] {10, 20, 25, 30, 5, 9}, 5)); // 4
    }
}