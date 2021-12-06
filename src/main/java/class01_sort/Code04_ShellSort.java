package class01_sort;

import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/4
 */
public class Code04_ShellSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(100000, 100000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    // 希尔排序

    public static void sort(int[] arr) {
        int l = arr.length;
        int now;
        for (int skip = l / 2; skip >= 1; skip /= 2) {
            for (int i = skip; i < l; i++) {
                int preIndex = i - skip;
                now = arr[i];
                while (preIndex >= 0 && arr[preIndex] > now) {
                    arr[preIndex + skip] = arr[preIndex];
                    preIndex -= skip;
                }
                arr[preIndex + skip] = now;
            }
        }
    }
}
