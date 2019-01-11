package archive;

class ShiftedBinarySearch {


    public int find(int value, int[] arr) {
        return find(value, arr, 0, arr.length - 1);
    }

    public int find(int value, int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (arr[mid] == value) {
            return mid;
        }

        if (arr[low] <= arr[mid]) {
            if (value >= arr[low] && value < arr[mid]) {
                return find(value, arr, low, mid - 1);
            } else {
                return find(value, arr, mid + 1, high);
            }
        } else {
            if (value > arr[mid] && value <= arr[high]) {
                return find(value, arr, mid + 1, high);
            } else {
                return find(value, arr, low, mid - 1);
            }
        }
    }
}
