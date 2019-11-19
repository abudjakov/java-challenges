package dynamic;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

// time O(N^2), space O(N)
public class BoxStacking {

    private static class Result {
        public int maxHeight;
        public List<Integer[]> stack;

        public Result(int maxHeight, List<Integer[]> stack) {
            this.maxHeight = maxHeight;
            this.stack = stack;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Result.class.getSimpleName() + "[", "]")
                    .add("maxHeight=" + maxHeight)
                    .add("stack=" + stack.stream().map(Arrays::toString).collect(Collectors.joining()))
                    .toString();
        }
    }

    public static Result solution(List<Integer[]> list, boolean canRotate) {
        List<Integer[]> boxes = canRotate ? rotate(list) : list;
        boxes.sort(Comparator.comparingInt(box -> -box[0] * box[1])); // descending by area (width x depth)
        boxes.forEach(box -> System.out.println(Arrays.toString(box)));

        int[] heights = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            heights[i] = boxes.get(i)[2];
        }
        int[] sequence = new int[boxes.size()];
        Arrays.fill(sequence, -1);

        int maxHeightInd = 0;
        for (int i = 1; i < heights.length; i++) {
            Integer[] box = boxes.get(i);
            for (int j = 0; j < i; j++) {
                Integer[] c = boxes.get(j);
                if (box[0] < c[0] && box[1] < c[1]) {
                    if (heights[j] + box[2] > heights[i]) {
                        heights[i] = heights[j] + box[2];
                        sequence[i] = j;
                    }
                }
            }
            if (heights[i] > heights[maxHeightInd]) {
                maxHeightInd = i;
            }
        }

        List<Integer[]> stack = new ArrayList<>();
        int ind = maxHeightInd;
        while (ind != -1) {
            stack.add(boxes.get(ind));
            ind = sequence[ind];
        }

        return new Result(heights[maxHeightInd], stack);
    }

    /**
    * [width, depth, height]. Building new boxes with different height and width < depth
    * */
    private static List<Integer[]> rotate(List<Integer[]> boxes) {
        List<Integer[]> rotated = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            Integer[] box = boxes.get(i);
            rotated.add(new Integer[]{Math.min(box[1], box[2]), Math.max(box[1], box[2]), box[0]});
            rotated.add(new Integer[]{Math.min(box[0], box[2]), Math.max(box[0], box[2]), box[1]});
            rotated.add(new Integer[]{Math.min(box[0], box[1]), Math.max(box[0], box[1]), box[2]});
        }
        return rotated;
    }



    public static void main(String[] args) {
        // width, depth, height
        List<Integer[]> list = new ArrayList<>();
        list.add(new Integer[]{1, 2, 4});
        list.add(new Integer[]{3, 2, 5});

        System.out.println(solution(list, true)); // 11 [1, 2, 4][2, 3, 5][3, 5, 2]

        list = new ArrayList<>();
        list.add(new Integer[]{2, 1, 2});
        list.add(new Integer[]{3, 2, 3});
        list.add(new Integer[]{2, 2, 8});
        list.add(new Integer[]{2, 3, 4});
        list.add(new Integer[]{1, 3, 1});
        list.add(new Integer[]{4, 4, 5});
        System.out.println(solution(list, false)); // 13 [2, 2, 8][4, 4, 5]
    }
}
