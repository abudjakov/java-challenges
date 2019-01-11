package functional;

import java.util.function.Function;

public class Recursion {


    public static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static long factorialIter(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorailTail(int n) {
        return factorialTail_(1, n).eval();
    }

    private static TailCall<Integer> factorialTail_(int result, int n) {
        return (n == 0)
                ? new TailCall.Result<>(result)
                : new TailCall.Suspend<>(() -> factorialTail_(result * n, n - 1));
    }


    private static Function<Integer, Function<Integer, TailCall<Integer>>> factorial_ =
            a -> b -> b == 0
                    ? new TailCall.Result<>(a)
                    : new TailCall.Suspend<>(() -> Recursion.factorial_.apply(a * b).apply(b - 1));

    public static Function<Integer, Integer> factorial = n -> factorial_.apply(1).apply(n).eval();


    public static int fibonachi(int n) {
        if (n <= 1)
            return 1;
        return fibonachi(n - 2) + fibonachi(n - 1);
    }

    //     1 1 2 3 5 8
    // x y z
    //   x y z

    public static int fibonachiIter(int n) {
        int x, y = 0, z = 1;
        for (int i = 1; i <= n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }

    static int addRec(int x, int y) {
        return y == 0
                ? x
                : addRec(++x, --y);
    }


    public static void main(String[] args) {
//        System.out.println(addRec(3, 21000));

        System.out.println(factorial(0));
        System.out.println(factorialIter(0));
        System.out.println(factorailTail(0));
        System.out.println(factorial.apply(0));

        System.out.println(factorial(5));
        System.out.println(factorialIter(5));
        System.out.println(factorailTail(5));
        System.out.println(factorial.apply(5));

        for (int i = 0; i < 10; i++) {
            System.out.print(fibonachi(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonachiIter(i) + " ");
        }
    }
}
