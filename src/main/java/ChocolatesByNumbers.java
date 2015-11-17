public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        return N / rgd(N, M);
    }

    public int rgd(int a, int b) {
        return (a % b == 0) ? b : rgd(b, a % b);
    }
}
