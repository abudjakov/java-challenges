import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FibFrog {

    public class Step {
        private int pos;
        private int count;

        public Step(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }
    }

    public int solution(int[] A) {

        int N = A.length;

        List<Integer> fib = sequenceFib(N);
        List<Step> steps = new ArrayList<Step>();
        steps.add(new Step(-1, 0));

        int count = 0;
        while (count++ <= N) {

            if (steps.isEmpty())
                return -1;

            Step step = steps.remove(0);

            for (Integer f : fib) {
                int ind = step.pos + f;
                if (ind == N)
                    return ++step.count;

                if (ind < N && A[ind] == 1) {
                    steps.add(new Step(ind, step.count + 1));
                    A[ind] = 0;
                }
            }

        }

        return -1;
    }

    private List sequenceFib(int length) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);

        while (list.get(list.size() - 1) <= length) {
            list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
        }

        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        FibFrog solution = new FibFrog();
        assert solution.solution(new int[]{0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}) == 3;
        assert solution.solution(new int[]{1, 1, 0, 0, 0}) == 2;
    }
}
