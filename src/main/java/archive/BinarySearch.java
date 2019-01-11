package archive;

class BinarySearch {


    public int index(int value, int[] arr) {
        return index(value, arr, 0, arr.length - 1);
    }

    public int index(int value, int[] arr, int low, int high) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;
        if (value < arr[mid])
            return index(value, arr, low, mid - 1);
        if (value > arr[mid])
            return index(value, arr, mid + 1, high);

        return mid;

    }


}
