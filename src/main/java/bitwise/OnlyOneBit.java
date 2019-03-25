package bitwise;

public class OnlyOneBit {

    public static boolean onlyOne(int num) {
        return (num & (num - 1)) == 0;
    }

    public static void onlyOneInSet() {
        for (int i = 0; i < 32; i++) {
            int a = 1 << i;
            assert onlyOne(a);
        }
    }

    public static void main(String[] args) {
        onlyOneInSet();
    }
}
