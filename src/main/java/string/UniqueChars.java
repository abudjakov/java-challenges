package string;

// Solution for ASCII (2^7)
public class UniqueChars {


    static boolean isUnique(String str) {
        if (str.length() > 128) {
            return false;
        }

        int set = 0;
        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i) - 'a';
            if ((set & (1 << code)) > 0) {
                return false;
            }

            set |= (1 << code);
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println((int) 'a');
//        System.out.println((int) 'z');
//        System.out.println((int) 'A');

        System.out.println(UniqueChars.isUnique("abcdef")); // true
        System.out.println(UniqueChars.isUnique("abcdbe")); // false

    }
}
