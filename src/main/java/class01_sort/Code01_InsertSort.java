package class01_sort;

import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/4
 */
public class Code01_InsertSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(100000, 1000000);
//        System.out.println(Arrays.toString(arr));
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
//        System.out.println(Arrays.toString(arr));
        System.out.printf("%s ms", (l2 - l1));
    }

    // 插入排序 从小到大

    // 帮助理解
    public static void sort0(int[] arr) {
        int l = arr.length;
        for (int i = 1; i < l; i++) {
            int now = arr[i];
            for (int j = i; j > 0; j--) {
                if (now > arr[j - 1]) {
                    break;
                } else {
                    RanArr.swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void sort(int[] arr) {
        int l = arr.length;
        for (int i = 1; i < l; i++) {
            int preIndex = i - 1;
            int now = arr[i];
            while (preIndex >= 0 && arr[preIndex] > now) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            // arr[preIndex - 1] < now , 故下标 为 preIndex
            arr[preIndex + 1] = now;
        }
    }


}
