package class01_sort;

import java.util.Arrays;

/**
 * 桶排序
 * @author masun
 * @date 2021/12/6
 */
public class Code09_BucketSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(10000000, 100000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    public static void sort(int[] arr) {
        bucketSort(arr, 30000);
    }

    public static void bucketSort(int[] arr, int bucketSize) {

        // 遍历数组 arr，找到 最大最小值
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            } else if (value < minValue) {
                minValue = value;
            }
        }
        // 计算桶 个数
        int bucketCount = (maxValue - minValue) / bucketSize + 1;

        int[][] buckets = new int[bucketCount][0];

        for (int i = 0; i < arr.length; i++) {
            // 计算 arr[i] 属于第 n 个桶，索引就是 n-1
            int i1 = (arr[i] - minValue) / bucketSize + 1 - 1;
            buckets[i1] = appendArr(buckets[i1], arr[i]);
        }

        int arrIndex = 0;

        // 遍历每个桶
        for (int[] b : buckets) {
            if (b.length <= 0) {
                continue;
            }
            // 使用插入排序 排序桶中整数
            Code01_InsertSort.sort(b);
            for (int val : b) {
                arr[arrIndex++] = val;
            }
        }

    }

    // 扩容指定数组，将 value 添加到尾部
    private static int[] appendArr(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
