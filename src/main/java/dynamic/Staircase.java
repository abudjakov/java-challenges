package dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Staircase {

    // brute force
    public static int calculate(int[] steps, int height) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        calculate(steps, height, candidates, results);

        log.info("steps {}, height {}, combination: {}", Arrays.toString(steps), height, results);

        return results.size();
    }

    public static void calculate(int[] steps, int height, List<Integer> candidates, List<List<Integer>> results) {
        if (sum(candidates) == height) {
            results.add(new ArrayList<>(candidates));
            return;
        }
        if (sum(candidates) > height) {
            return;
        }
        for (int i = 0; i < steps.length; i++) {
            candidates.add(steps[i]);
            calculate(steps, height, candidates, results);
            candidates.remove(candidates.size() - 1);
        }
    }

    public static int sum(List<Integer> candidates) {
        return candidates.stream().mapToInt(Integer::intValue).sum();
    }

    public static int number_of_ways(int[] steps, int n) {
        if (n == 0) return 1;
        int count = 0;
        for (int step : steps) {
            if (n - step >= 0)
                count += number_of_ways(steps, n - step);
        }
        return count;
    }

    // Time is: N * S
    public static int number_of_ways_down_up(int[] steps, int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < steps.length; j++) {
                int diff = i - steps[j];
                if (diff < 0) continue;
                memo[i] += memo[diff];
            }
            System.out.println("i = " + i + " " + Arrays.toString(memo));
        }
        return memo[n];
    }

    public static void main(String[] args) {
//        log.info("steps [1, 2], height 2: {}", calculate(new int[]{1, 2}, 2)); // 2
//        log.info("steps [1, 2], height 2: {}", calculate(new int[]{1, 2}, 3)); // 3
//        log.info("steps [1, 2], height 2: {}", calculate(new int[]{1, 2}, 4)); // 5
//        log.info("steps [1, 2], height 2: {}", calculate(new int[]{1, 2}, 5)); // 8
//        log.info("steps [1, 2], height 2: {}", calculate(new int[]{1, 3, 5}, 10)); // 47
//
//        log.info("number_of_ways: {}", number_of_ways(new int[]{1, 2, 5, 10}, 10)); // 129
        log.info("number_of_ways_down_up: {}", number_of_ways_down_up(new int[]{1, 2}, 5)); // 8
//        log.info("number_of_ways_down_up: {}", number_of_ways_down_up(new int[]{1, 2, 5, 10}, 10)); // 129
    }


}
