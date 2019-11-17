package classic;

public class TowerHanoi {

    static void solution(int n, String from_rod, String to_rod, String aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }

        solution(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        solution(n - 1, aux_rod, to_rod, from_rod);
    }

    public static void main(String[] args) {
        solution(3, "A", "C", "B");
    }
}
