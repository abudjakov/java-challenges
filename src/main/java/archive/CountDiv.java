package archive;

public class CountDiv {

    public int solution(int A, int B, int K) {
        if (A % K == 0)
            return (B - A) / K + 1;

        return (B - (A - A % K )) / K;
    }
}

