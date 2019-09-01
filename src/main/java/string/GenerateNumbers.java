package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateNumbers {

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

    public static void main(String[] args) {
        generateNumbers(2, 2, "");
        generateNumbers(2, 2, new ArrayList<>());
    }
}
