package string;


/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/

import java.util.ArrayList;
import java.util.List;

// Time: O(n)
// Space: O(1)
public class IPAddressDecomposition {

    public static List<String> solution(String s) {
        List<String> ips = new ArrayList<>();
        List<String> segments = new ArrayList<>();
        findIp(ips, s, segments, 0);
        return ips;
    }

    public static void findIp(List<String> ips, String s, List<String> segments, int index) {
        // base case = goal
        if (index == s.length() && segments.size() == 4) {
            ips.add(String.join(".", segments));
            return;
        }

        // kill overshoots
        if (index == s.length() || segments.size() == 4) {
            return;
        }

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String candidate = s.substring(index, index + i);
            // constraints
            if ((candidate.length() > 1 && candidate.startsWith("0")) || Integer.parseInt(candidate) > 255) {
                break;
            }
            // choose, explore, unchoose
            segments.add(candidate);
            findIp(ips, s, segments, index + i);
            segments.remove(segments.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("25525511135")); // 255.255.11.135, 255.255.111.35
        System.out.println(solution("255011127")); // 25.50.11.127, 25.50.111.27, 255.0.11.127, 255.0.111.27
    }
}
