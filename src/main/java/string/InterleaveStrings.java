package string;

import java.util.ArrayList;
import java.util.List;

// interleave("", "abc") = {"abc"}
// interleave("1", "abc") = {"1abc", "a1bc", "ab1c", "abc1"}
// interleave("12", "abc") = {"12abc", "1a2bc", "1ab2c", "1abc2", "a12bc", "a1b2c", "a1bc2", "ab12c", "ab1c2" "abc12"}
public class InterleaveStrings {

    public static List<String> interleave(String s, String t) {
        List<String> result = new ArrayList<>();
        if (t.isEmpty()) {
            result.add(s);
        } else if (s.isEmpty()) {
            result.add(t);
        } else {
            for (int i = 0; i <= s.length(); i++) {
                char c = t.charAt(0);
                String left = s.substring(0, i);
                String right = s.substring(i);
                for (String u : interleave(right, t.substring(1))) {
                    result.add(left + c + u);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(interleave("ab", "12"));
//        System.out.println(interleave("abc", "123"));
    }
}
