package bitwise;

public class AppearsOnce {

    static int findOneNotRepeated(int arr[]) {
        int ones = 0;
        int twos = 0;
        int common;

        for (int i = 0; i < arr.length; i++) {
            twos = twos | (ones & arr[i]);

            ones = ones ^ arr[i];

            common = ~(ones & twos);

            ones &= common;

            twos &= common;
        }

        return ones;
    }

    static int findOneNotRepeated(int arr[], int intSize) {
        int result = 0;
        int x;
        int sum;

        for (int i = 0; i < intSize; i++) {
            sum = 0;
            x = (1 << i);
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & x) > 0)
                    sum++;
            }

            if ((sum % 3) != 0)
                result |= x;
        }

        return result;
    }

    public static void main(String args[]) {
        int arr[] = {3, 5, 3, 3};
        System.out.println("once: " + findOneNotRepeated(arr, 32));
    }
}