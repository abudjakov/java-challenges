package array;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class MaximumWeightInterval {

    public static int maxWeight(int[][] data) {
        List<Interval> list = Stream.of(data).map(a -> Interval.builder()
                .start(a[0]).end(a[1]).weight(a[2]).build())
                .collect(Collectors.toList());

        List<Interval> start = Lists.newArrayList(list);
        start.sort(comparing(Interval::start));

        List<Interval> end = Lists.newArrayList(list);
        end.sort(comparing(Interval::end));

        int load = 0;
        int max = 0;
        int i = 0;
        int j = 0;

        while (i < start.size() && j < end.size()) {
            if (start.get(i).start <= end.get(j).end) {
                load += start.get(i).weight;
                max = Math.max(max, load);
                i++;
            } else {
                load -= end.get(j).weight;
                j++;
            }
        }

        return max;

    }

    @Builder
    @Accessors(fluent = true)
    @Getter
    static class Interval {
        int start;
        int end;
        int weight;
    }

    public static void main(String[] args) {
        assert maxWeight(new int[][]{{3, 7, 4}, {1, 3, 6}, {4, 9, 5}}) == 10 : "not 10";
        assert maxWeight(new int[][]{{3, 7, 4}, {1, 3, 6}, {4, 9, 5}, {10, 11, 11}}) == 11 : "not 11";
        assert maxWeight(new int[][]{{3, 7, 4}, {1, 3, 6}, {4, 9, 5}, {10, 11, 11}, {3, 4, 2}}) == 12 : "not 12";


    }
}
