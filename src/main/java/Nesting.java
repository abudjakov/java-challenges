import java.util.Stack;

public class Nesting {

    public int solution(String S) {
        Stack<Boolean> stack = new Stack<Boolean>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(true);
            }
            else if (!stack.isEmpty()) {
                stack.pop();
            }
            else {
                return -1;
            }
        }

        return stack.isEmpty() ? 0 : -1;
    }
}
