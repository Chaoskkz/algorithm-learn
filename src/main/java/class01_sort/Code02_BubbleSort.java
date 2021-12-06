package class01_sort;

import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/4
 */
public class Code02_BubbleSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(100000,1000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.printf("%s ms",(l2-l1));
    }

    // 冒泡排序
    public static void sort(int[] arr) {

        int l = arr.length;
        // i 表示 第 i+1 轮冒泡
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (arr[j] >= arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
