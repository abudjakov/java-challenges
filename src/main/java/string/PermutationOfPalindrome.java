package string;

public class PermutationOfPalindrome {

    public static boolean isValid(String str) {
        int bit = bit(str);
        return bit == 0 || bit + (bit - 1) == 0;
    }

    static int bit(String str) {
        int bit = 0;
        for (char c : str.toCharArray()) {
            int index = index(c);
            bit = add(bit, index);
        }
        return bit;
    }

    static int index(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int index = Character.getNumericValue(c);
        if (index <= a && index <= z) {
            return index - a;
        }

        return -1;
    }

    static int add(int bit, int index) {
        if (index < 0) return bit;

        int mask = 1 << index;
        bit ^= mask;

        return bit;
    }

    public static void main(String[] args) {
        System.out.println(PermutationOfPalindrome.isValid("taco cat"));
        System.out.println(PermutationOfPalindrome.isValid("abcab"));
        System.out.println(PermutationOfPalindrome.isValid("AB cAbC"));
        System.out.println(PermutationOfPalindrome.isValid("ABbC"));
    }
}
