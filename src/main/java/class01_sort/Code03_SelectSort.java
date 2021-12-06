package class01_sort;

import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/4
 */
public class Code03_SelectSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(100000,100);
//        System.out.println(Arrays.toString(arr));
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        System.out.printf("%s ms",(l2-l1));
    }

    // 选择排序 小到大

    public static void sort(int[] arr) {
        int l = arr.length;
        // 只需进行 l-1 轮选择
        for (int i = 0; i < l - 1; i++) {
            int maxIndex = 0;
            for (int j = 0; j < l - i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            RanArr.swap(arr, l - 1 - i, maxIndex);
        }
    }
}
