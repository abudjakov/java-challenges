package expression;

import java.util.stream.Stream;

public class ArithmeticEval {

    public static int eval(String expression) {
        return Stream.of(expression.split("\\s*\\+\\s*"))
                .mapToInt(m -> Stream.of(m.split("\\s*\\*\\s*"))
                        .mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b))
                .reduce(0, (a, b) -> a + b);
    }


    public static void main(String[] args) {
        assert eval("3 * 5 * 2 + 1 + 2 * 4 + 5") == 44 : "miscalculation";
    }
}
