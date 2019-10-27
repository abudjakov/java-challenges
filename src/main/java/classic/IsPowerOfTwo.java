package classic;

public class IsPowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 2 == 0) n /= 2;

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8)); //true
        System.out.println(isPowerOfTwo(16)); //true
        System.out.println(isPowerOfTwo(20)); // false
        System.out.println(isPowerOfTwo(6));
    }
}
