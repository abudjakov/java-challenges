package string;

import java.util.Arrays;

public class PatternMatcher {

    // O(n^2 + m) time | O(n + m) space
    public static String[] solution(String pattern, String str) {
        if (pattern.length() > str.length()) {
            return new String[0];
        }

        char[] charPattern = charPattern(pattern);
        System.out.println("charPattern " + Arrays.toString(charPattern));
        boolean rotated = charPattern[0] != pattern.charAt(0);

        int countX = 0;
        int countY = 0;
        int indexY = -1;
        for (int i = 0; i < charPattern.length; i++) {
            if (charPattern[i] == 'x') {
                countX++;
            }
            else if (charPattern[i] == 'y') {
                countY++;
                if (indexY == -1) {
                    indexY = i;
                }
            }
        }
        System.out.println("count x: " + countX + ", count y: " + countY + ", index y: " + indexY);

        // or countY = 0
        if (indexY == -1) {
            int len = str.length() / countX;
            String x = str.substring(0, len);
            String y = "";
            String newStr = buildString(x, y, charPattern);
            if (str.equals(newStr)) {
                return rotated ? new String[]{y, x} : new String[]{x, y};
            }
            return new String[0];
        }

        int lenX = 1;
        while (lenX <= str.length() / countX) {
            int lenY = (str.length() - lenX * countX) / countY;
            System.out.println("lenX: " + lenX + ", lenY: " + lenY);
            String x = str.substring(0, lenX);
            String y = str.substring(indexY * lenX, indexY * lenX + lenY);
            String newStr = buildString(x, y, charPattern);
            System.out.println("x: " + x + ", y: " + y + ", newStr: " + newStr);
            if (str.equals(newStr)) {
                return rotated ? new String[]{y, x} : new String[]{x, y};
            }
            lenX++;
        }

        return new String[0];
    }

    private static String buildString(String x, String y, char[] charPattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charPattern.length; i++) {
            if (charPattern[i] == 'x') {
                sb.append(x);
            }
            else if (charPattern[i] == 'y') {
                sb.append(y);
            }
        }
        return sb.toString();
    }

    private static char[] charPattern(String pattern) {
        char[] charPattern = pattern.toCharArray();
        if (pattern.charAt(0) == 'x') {
            return charPattern;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'x') {
                charPattern[i] = 'y';
            }
            else if (pattern.charAt(i) == 'y') {
                charPattern[i] = 'x';
            }
        }

        return charPattern;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("xyxy", "abab"))); // [a, b]
        System.out.println(Arrays.toString(solution("yxyx", "abab"))); // [b, a]
    }
}
