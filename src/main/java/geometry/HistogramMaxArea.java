package geometry;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class HistogramMaxArea {

    static int calculate(int[] hist) {
        Stack<Integer> s = new Stack<>();

        int max_area = 0;

        int i = 0;
        while (i < hist.length) {
            if (s.empty() ||  hist[i] >= hist[s.peek()]) {
                s.push(i++);
                continue;
            }

            int top = s.pop();
            int h = hist[top];
            int w = s.empty()
                    ? i
                    : i - s.peek() - 1;

            max_area = Math.max(h * w, max_area);
            log.info("i: {}, top: {}, h: {}, w: {}, max: {}", i, top, h, w, max_area);
        }

        while (!s.empty()) {
            int top = s.pop();
            int h = hist[top];
            int w = s.empty()
                    ? i
                    : i - s.peek() - 1;

            max_area = Math.max(h * w, max_area);
            log.info("> i: {}, top: {}, h: {}, w: {}, max: {}", i, top, h, w, max_area);
        }

        return max_area;
    }


    public static void main(String[] args) {
//        System.out.println("Maximum area is " + calculate(new int[]{6, 2, 5, 4, 5, 1, 6})); // 12
//        System.out.println("Maximum area is " + calculate(new int[]{1, 2, 3, 3, 1, 4, 0, 1, 2})); // 6
        System.out.println("Maximum area is " + calculate(new int[]{1, 2, 0, 2, 2, 0, 3, 3})); // 4
    }
}
