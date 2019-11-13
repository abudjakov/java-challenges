package string;


import java.util.Arrays;

public class LongestCommonSubsequence {

    public static int lcs(String a, String b) {
        return lcs(a, b, a.length(), b.length());
    }

    public static int lcs(String a, String b, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return 1 + lcs(a, b, n - 1, m - 1);
        } else {
            return Math.max(lcs(a, b, n, m - 1), lcs(a, b, n - 1, m));
        }
    }

    public static int lcsTabulated(String a, String b) {
        return lcsTabulated(a, b, a.length(), b.length());
    }

    public static int lcsTabulated(String a, String b, int n, int m) {

        int[][] arr = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
                }
            }
        }

        print(a, b, arr);

        int lcs = arr[n][m];
        char[] chars = new char[lcs];

        int i = n;
        int j = m;
        int ind = lcs - 1;

        while (i > 0 && j > 0) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                chars[ind--] = a.charAt(i - 1);
                i--;
                j--;
                continue;
            }

            if (arr[i - 1][j] > arr[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(String.format("lcs string: %s, count: %s\n", Arrays.toString(chars), lcs));

        return lcs;
    }

    private static void print(String a, String b, int[][] arr) {
        System.out.println("     " + Arrays.toString(b.toCharArray()));
        for (int i = 0; i < arr.length; i++) {
            String l = i == 0 ? "  " : a.charAt(i - 1) + " ";

            System.out.println(l + Arrays.toString(arr[i]));
        }
    }


    public static void main(String[] args) {
//        System.out.println(lcs("ABCDGH", "AEDFHR")); // 3 ADH
//        System.out.println(lcs("AGGTAB", "GXTXAYB")); // 4 GTAB

        lcsTabulated("ABCDGH", "AEDFHR"); // 3 ADH
        lcsTabulated("AGGTAB", "GXTXAYB"); // 4 GTAB

    }
}

/*
     [A, E, D, F, H, R]
  [0, 0, 0, 0, 0, 0, 0]
A [0, 1, 1, 1, 1, 1, 1]
B [0, 1, 1, 1, 1, 1, 1]
C [0, 1, 1, 1, 1, 1, 1]
D [0, 1, 1, 2, 2, 2, 2]
G [0, 1, 1, 2, 2, 2, 2]
H [0, 1, 1, 2, 2, 3, 3]
3
     [G, X, T, X, A, Y, B]
  [0, 0, 0, 0, 0, 0, 0, 0]
A [0, 0, 0, 0, 0, 1, 1, 1]
G [0, 1, 1, 1, 1, 1, 1, 1]
G [0, 1, 1, 1, 1, 1, 1, 1]
T [0, 1, 1, 2, 2, 2, 2, 2]
A [0, 1, 1, 2, 2, 3, 3, 3]
B [0, 1, 1, 2, 2, 3, 3, 4]
4

 */