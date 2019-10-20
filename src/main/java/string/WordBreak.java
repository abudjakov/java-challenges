package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    // Time: exponential
    public static boolean recursion(Set<String> dict, String string) {
        if (string.length() == 0)
            return true;

        for (int i = 1; i <= string.length(); i++) {
            String prefix = string.substring(0, i);

            if (dict.contains(prefix) && recursion(dict, string.substring(i)))
                return true;
        }

        return false;
    }

    // Time: S length * dict size
    public static boolean wordBreak(Set<String> dict, String string) {
        boolean[] memo = new boolean[string.length() + 1];
        memo[0] = true;

        for (int i = 0; i < string.length(); i++) {
            if (!memo[i])
                continue;

            for (String dictWord : dict) {
                int len = dictWord.length();
                int end = i + len;
                if (end > string.length())
                    continue;

                if (memo[end]) continue;

                if (string.substring(i, end).equals(dictWord)) {
                    memo[end] = true;
                }
            }
        }

        return memo[string.length()];
    }

    // Time: S * S
    public static boolean wordBreak2(Set<String> dict, String string) {
        boolean[] memo = new boolean[string.length() + 1];
        memo[0] = true;

        for (int i = 0; i < string.length(); i++) {
            if (!memo[i])
                continue;

            for (int j = i + 1; j <= string.length(); j++) {
                String sub = string.substring(i, j);
                if (dict.contains(sub)) {
                    memo[j] = true;
                }
            }
        }

        return memo[string.length()];
    }

    public static void main(String[] args) {
        String[] dict = {"this", "is", "famous", "Word", "break", "problem"};

        Set<String> dictionary = new HashSet<>(Arrays.asList(dict));

        System.out.println(recursion(dictionary, "Word"));
        System.out.println(recursion(dictionary, "Wordbreak"));
        System.out.println(recursion(dictionary, "Wordbreakproblem"));
        System.out.println(recursion(dictionary, "Thefamousproblem"));

        System.out.println("-----");

        System.out.println(wordBreak(dictionary, "Word"));
        System.out.println(wordBreak(dictionary, "Wordbreak"));
        System.out.println(wordBreak(dictionary, "Wordbreakproblem"));
        System.out.println(wordBreak(dictionary, "Thefamousproblem"));

        System.out.println("-----");

        System.out.println(wordBreak2(dictionary, "Word"));
        System.out.println(wordBreak2(dictionary, "Wordbreak"));
        System.out.println(wordBreak2(dictionary, "Wordbreakproblem"));
        System.out.println(wordBreak2(dictionary, "Thefamousproblem"));
    }
}
