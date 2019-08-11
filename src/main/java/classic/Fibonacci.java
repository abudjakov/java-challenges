package classic;

public class Fibonacci {

    public static void firstNumbers(int n) {
        int f = 0, g = 1;

        for (int i = 1; i <= n; i++) {
            f = f + g;
            g = f - g;
            System.out.println(f);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        firstNumbers(10);
        System.out.println("10 -> " + fibonacci(10));
    }
}

