package string;


// https://leetcode.com/submissions/detail/263207868/


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// KMP algorithm
public class KnuthMorrisPratt {

    public static List<Integer> search(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<>();

        if (pattern.length() == 0 || text.length() == 0) {
            return Collections.singletonList(-1);
        }

        int pl = pattern.length();
        int tl = text.length();

        int[] lps = createLps(pattern);

        int i = 0;
        int j = 0;
        while (i < tl) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pl) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < tl && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }

        }

        return result;
    }

    private static int[] createLps(String pattern) {
        int[] lps = new int[pattern.length()];

        int i = 0;
        int j = 1;
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                }
                else {
                    i = lps[i - 1];
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(createLps("AAAA"))); // [0, 1, 2, 3]
//        System.out.println(Arrays.toString(createLps("ABCDE"))); // [0, 0, 0, 0, 0]
//        System.out.println(Arrays.toString(createLps("AABAACAABAA"))); // [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]
//        System.out.println(Arrays.toString(createLps("AAACAAAAAC"))); // [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
//        System.out.println(Arrays.toString(createLps("AAABAAA"))); // [0, 1, 2, 0, 1, 2, 3]

        System.out.println(search("TEST", "THIS IS A TEST TEXT")); // 10
        System.out.println(search("AABA", "AABAACAADAABAABA")); // 0, 9, 12
    }
}
