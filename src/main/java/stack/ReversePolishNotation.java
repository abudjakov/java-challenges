package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.IntBinaryOperator;

/*
 If operand push it into stack
 If operator pop twice and push calculation result into stack
* */
public class ReversePolishNotation {

    public static int solution(String expression) {
        String[] arr = expression.split("\\s+");

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            switch (s) {
                // operator
                case "+":
                    calc(stack, (a, b) -> b + a);
                    break;
                case "-":
                    calc(stack, (a, b) -> b - a);
                    break;
                case "*":
                    calc(stack, (a, b) -> b * a);
                    break;
                case "/":
                    calc(stack, (a, b) -> b / a);
                    break;
                default:
                    // operand
                    stack.push(Integer.valueOf(s));
            }
        }

        return stack.size() != 1 ? -1 : stack.peek();
    }

    public static void calc(Deque<Integer> stack, IntBinaryOperator operator) {
        stack.push(operator.applyAsInt(stack.pop(), stack.pop()));
    }

    public static void main(String[] args) {
        System.out.println(solution("15 7 1 1 + - / 3 * 2 1 1 + + -")); // 5
        System.out.println(solution("1 2 + 4 * 5 + 3 -")); // 14
        System.out.println(solution("1 2 + 3")); // -1

    }
}
