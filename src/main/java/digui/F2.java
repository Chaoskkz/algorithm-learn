package digui;

import java.util.Random;

/**
 * @author masun
 * @date 2021/12/4
 */
public class F2 {

    static int N = 1500;
    static int[][] arr = new int[N][N];


    static int[][] arrCache = new int[N][N];

    static {
        Random r=new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j]= r.nextInt(100);
            }
        }
    }


    public static int getMax(int i, int j) {
        if (arrCache[i][j] != 0) {
            return arrCache[i][j];
        }
        if (i == N - 1) {
            return arr[i][j];
        }
        int max1 = getMax(i + 1, j);
        int max2 = getMax(i + 1, j + 1);
        int i1 = Math.max(max1, max2) + arr[i][j];
        arrCache[i][j] = i1;
        return i1;
    }
}
