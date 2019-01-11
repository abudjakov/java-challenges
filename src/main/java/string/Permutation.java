package string;

// Permutations for n from n: n!
// Permutations for k from n: n! / (n - k)!
// Combinations for k from n: n! / (k! * (n - k)!)
public class Permutation {

    void permutation(String s) {
        permutation(s, "");
    }

    private void permutation(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String r = s.substring(0, i) + s.substring(i + 1);
                permutation(r, prefix + s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new Permutation().permutation("12345");
    }


}
