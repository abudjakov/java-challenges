package functional;

/**
 * Greatest common divisor
 */
public class GCD {

    public static int gcd(int a, int b) {
        if (a == 0 || b  == 0) {
            return 0;
        }

        if (a == b) {
            return a;
        }

        return a > b ? gcd(a - b, b) : gcd(a, b - a);
    }


    public static void main(String[] args) {
        System.out.println(gcd(5, 3)); // 1
        System.out.println(gcd(5, 15)); // 5
        System.out.println(gcd(6, 21)); // 3


    }
}
