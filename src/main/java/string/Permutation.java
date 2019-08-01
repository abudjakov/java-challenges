package string;

import java.util.ArrayList;
import java.util.List;

// Permutations for n from n: n!
// Permutations for k from n: n! / (n - k)!
// Combinations for k from n: n! / (k! * (n - k)!)
public class Permutation {

    private static void permutations(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String r = s.substring(0, i) + s.substring(i + 1);
                permutations(r, prefix + s.charAt(i));
            }
        }
    }

    private static void generateNumbers(int n, int m, List<Integer> prefix) {
        if (m == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                prefix.add(i);
                generateNumbers(n, m - 1, prefix);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    private static void generateNumbers(int n, int m, String prefix) {
        if (m == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generateNumbers(n, m - 1, prefix + i);
            }
        }
    }

    private static void generateBinary(int m, String prefix) {
        if (m == 0) {
            System.out.println(prefix);
        } else {
            generateBinary(m - 1, prefix + "0");
            generateBinary(m - 1, prefix + "1");
//            generateBinary(m - 1, prefix + "2");
        }
    }


    public static void main(String[] args) {
//        permutations("ABCD", "");
//        permutations("123", "");
        generateNumbers(3, 3, "");
//        generateNumbers(3, 3, new ArrayList<>());
//        generateBinary(4, "");
    }

}
