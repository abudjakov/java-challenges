package string;

import java.util.*;

public class WordBreakCombinations {

    public static List<String> wordBreak(Set<String> dict, String string) {
        ArrayList<String>[] pos = new ArrayList[string.length() + 1];
        pos[0] = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (pos[i] == null)
                continue;

            for (int j = i + 1; j <= string.length(); j++) {
                String sub = string.substring(i, j);

                if (dict.contains(sub)) {
                    if (pos[j] == null) {
                        pos[j] = new ArrayList<>();
                    }
                    pos[j].add(sub);
                }
            }
        }

        if (pos[string.length()] == null) {
            return new ArrayList<>();
        }

        ArrayList<String> result = new ArrayList<>();
        dfs(pos, result, "", string.length());
        return result;
    }

    private static void dfs(ArrayList<String>[] pos, ArrayList<String> result, String curr, int i) {
        if (i == 0) {
            result.add(curr.trim());
            return;
        }

        for (String s : pos[i]) {
            String combined = s + " " + curr;
            dfs(pos, result, combined, i - s.length());
        }
    }

    public static void main(String[] args) {
        String[] dict = {"this", "is", "famous", "Word", "break", "problem", "cat", "cats", "and", "sand", "dog"};

        Set<String> dictionary = new HashSet<>(Arrays.asList(dict));

        System.out.println(wordBreak(dictionary, "Word"));
        System.out.println(wordBreak(dictionary, "Wordbreak"));
        System.out.println(wordBreak(dictionary, "Wordbreakproblem"));
        System.out.println(wordBreak(dictionary, "Thefamousproblem"));
        System.out.println(wordBreak(dictionary, "catsanddog"));
    }
}
