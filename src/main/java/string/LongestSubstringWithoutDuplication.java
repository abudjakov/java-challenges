package string;

import java.util.HashMap;

public class LongestSubstringWithoutDuplication {

    public static String solution(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int[] max = {0, 1};
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                int ind = map.get(c);
                start = Math.max(start, ind + 1);
            }
            if (i - start + 1 > max[1] - max[0]) {
                max = new int[]{start, i + 1};
            }
            map.put(c, i);
        }
        return str.substring(max[0], max[1]);
    }

    public static void main(String[] args) {
       System.out.println(solution("nolongestno")); // longest
       System.out.println(solution("LongestSubstringWithoutDuplication")); // LongestSub
    }
}
