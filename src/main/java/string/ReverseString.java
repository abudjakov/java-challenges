package string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReverseString {

    public static String solution(String s) {
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        byte[] reversed = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            reversed[i] = bytes[bytes.length - i - 1];
        }
        System.out.println(Arrays.toString(bytes));
        return new String(reversed);
    }

    public static void main(String[] args) {
        assert "CBA".equals(solution("ABC"));
        assert "7FDcba".equals(solution("abcDF7"));
    }
}
