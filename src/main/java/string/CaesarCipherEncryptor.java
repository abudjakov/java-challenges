package string;

import java.util.Arrays;

public class CaesarCipherEncryptor {

    public static String solution(String str, int key) {
        char[] letters = new char[26];
        int num = 0;
        char c = 'a';
        while (c <= 'z') {
            letters[num] = c;
            num++;
            c++;
        }

        int k = key % 26; // 26 characters in alphabet

        //System.out.println(Arrays.toString(letters));
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char l = str.charAt(i);
            int ind = (Arrays.binarySearch(letters, l) + k) % 26;
            result[i] = letters[ind];
        }

        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(solution("xyza", 3)); // abcd
        System.out.println(solution("abc", 26)); // abc
    }
}
