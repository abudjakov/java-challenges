package array;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class RectangularAreaInHistogram {

    static int calculate(int[] hist) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int top;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() ||  hist[i] >= hist[s.peek()]) {
                s.push(i++);
                continue;
            }

            log.info("{}", s);
            top = s.pop();
            int area = hist[top] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area)
                max_area = area;

            log.info("->{}", s);
        }

        log.info("{}", s);
        while (!s.empty()) {
            top = s.pop();
            int area = hist[top] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area)
                max_area = area;
        }

        return max_area;

    }

    public static void main(String[] args) {
        int[] hist = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + calculate(hist)); //12
    }
}
