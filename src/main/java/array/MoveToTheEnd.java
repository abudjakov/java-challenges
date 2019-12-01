package array;

import java.util.Arrays;
import java.util.List;

public class MoveToTheEnd {

    public static List<Integer> solution(List<Integer> array, int toMove) {
        // O(n) time | O(1) space
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove) {
                j--;
            }
            if (array.get(i) == toMove) {
                array.set(i, array.get(j));
                array.set(j, toMove);
            }
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
//        System.out.println(solution(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));
        System.out.println(solution(Arrays.asList(5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12), 5));
    }
}
