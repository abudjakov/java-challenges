package array;

import java.util.Arrays;

public class HIndex {

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= citations.length - i){
                return citations.length - i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 1, 4, 2, 1, 3, 5, 6})); // 4
        System.out.println(solution(new int[]{1, 5, 1, 5, 2, 1, 3, 6, 7})); // 4
        System.out.println(solution(new int[]{25, 8, 5, 2, 2})); // 3
        System.out.println(solution(new int[]{10, 8, 5, 4, 3 })); // 4
        System.out.println(solution(new int[]{10, 8, 5, 3, 3 })); // 3
    }

}
