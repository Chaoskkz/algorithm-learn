package class01_sort;

/**
 * 计数排序
 *
 * @author masun
 * @date 2021/12/6
 */
public class Code08_CountingSort {

    // 计数排序，n 越大 相对越快
    // 空间 换 时间
    public static void main(String[] args) {
        int[] arr = RanArr.ran(10000000, -100000000, 100000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    public static void sort(int[] arr) {
//        countingSort(arr, 1, 100000000);
        countingSort(arr, getMinValue(arr), getMaxValue(arr));
    }


    private static void countingSort(int[] arr, int minValue, int maxValue) {
        int bucketLen = maxValue - minValue + 1;
        int baseLen = minValue;
        int[] bucket = new int[bucketLen];

        // 遍历 arr，将所有值出现 次数进行记录
        for (int value : arr) {
            bucket[value - baseLen]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j + baseLen;
                bucket[j]--;
            }
        }
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private static int getMinValue(int[] arr) {
        int minValue = arr[0];
        for (int value : arr) {
            if (minValue > value) {
                minValue = value;
            }
        }
        return minValue;
    }

}
