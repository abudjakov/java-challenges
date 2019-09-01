package string;

// Permutations for n from n: n!
// Permutations for k from n: n! / (n - k)!
// Combinations for k from n: n! / (k! * (n - k)!)

// Time: O(n * n!) - n! permutations and it takes O(n) time to add each one to result
// Space: O(n) - recursion goes maximum n elements deep
public class PermutationString {

    private static void permutations(String s, String prefix) {
        if (s.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                char candidate = s.charAt(i);
                String rest = s.substring(0, i) + s.substring(i + 1);
                permutations(rest, prefix + candidate);
            }
        }
    }


    private static void permutations2(String s, int start, int end) {
        if (start == end)
            System.out.println(s);
        else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permutations2(s, start + 1, end);
//                s = swap(s, start, i); // unchoose, but no effect to the string
            }
        }
    }

    public static String swap(String s, int i, int j) {
        char[] arr = s.toCharArray();
        char temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }

    public static void main(String[] args) {
//        permutations("ABC", "");
        permutations2("ABC", 0, 2);

    }

}


