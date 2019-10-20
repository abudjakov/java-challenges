package string;

// “abc” & “1” > “a1bc”
public class InterleaveSimple {

    public static String interleave(String a, String b) {
        int max = Math.max(a.length(), b.length());
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < max; i++) {
            if (i < a.length())
                s.append(a.charAt(i));
            if (i < b.length())
                s.append(b.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(interleave("abc", "123"));
        System.out.println(interleave("abc", "1"));
    }
}
