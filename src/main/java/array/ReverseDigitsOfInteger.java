package array;


// Time: O(n)
// Space: O(1)
public class ReverseDigitsOfInteger {

    public static int solution(int n) {
        int f = Math.abs(n);
        int r = 0;
        while (f > 0) {
            r = r * 10 + f % 10;
            f = f / 10;
        }

        return n < 0 ? -r : r;
    }

    public static void main(String[] args) {
        System.out.println(solution(4)); // 4
        System.out.println(solution(12345)); // 54321
        System.out.println(solution(33567802)); // 20876533
        System.out.println(solution(-905)); // -509
    }
}