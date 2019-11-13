package util;

public class ArraysPrint {

    public static void print(int[][] arr) {
        if (arr.length == 0)
            return;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
}
