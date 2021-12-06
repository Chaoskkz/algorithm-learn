package class01_sort;

import java.util.Random;

/**
 * @author masun
 * @date 2021/12/4
 */
public class RanArr {

    /**
     * 正整数 数组
     *
     * @param n
     * @param bound
     * @return
     */
    public static int[] ran(int n, int bound) {
        int[] arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(bound) + 1;
        }
        return arr;
    }

    /**
     * 含负整数、正整数 数组
     *
     * @param n
     * @param min 最小 包含
     * @param bound 最大值 包含
     * @return
     */
    public static int[] ran(int n, int min, int bound) {
        int[] arr = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = r.nextInt(bound - min + 1) + min;
        }
        return arr;
    }

    public static int[] ran() {
        return ran(10, 100);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
