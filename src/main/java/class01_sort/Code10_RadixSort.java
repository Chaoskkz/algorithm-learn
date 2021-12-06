package class01_sort;

import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/6
 */
public class Code10_RadixSort {
    public static void main(String[] args) {
        int[] arr = RanArr.ran(10000, 1000000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    public static void sort(int[] arr) {
        radixSort(arr, getMaxDigit(arr));
    }

    private final static int TEN = 10;

    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getIntDigit(maxValue);
    }


    private static void radixSort(int[] arr, int maxDigit) {
        final int mod = TEN;
        //  i:从 个位桶 到 最高位桶
        for (int i = 1; i <= maxDigit; i++) {
            // [0-9]   对应  0 到 9
            int[][] counter = new int[mod][0];

            // 遍历所有元素，添加到对应的基数桶尾部
            for (int j = 0; j < arr.length; j++) {
                // 计算桶索引下标
                // 如 92 对 个位 ， 桶索引为 2
                int bucketIndex = getDigitNum(arr[j], i);
                counter[bucketIndex] = appendArr(counter[bucketIndex], arr[j]);
            }

            // 将 i位数的 桶结果 覆盖 原数组
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
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

    // 获取 num 的位数 ，如 9878 的位数 为 4
    protected static int getIntDigit(int num) {
        if (num == 0) {
            return 1;
        }
        int digit = 0;
        for (int temp = num; temp != 0; temp /= TEN) {
            digit++;
        }
        return digit;
    }

    // 获取 整数n 的 第 digit 位数， 如 9878 的 第二位数为 7
    private static int getDigitNum(int n, int digit) {
        int mod = 1;
        for (int i = 1; i <= digit; i++) {
            mod *= 10;
        }
        // 9878 % 100 =78 ；78/10 = 7
        return (n % mod) / (mod / 10);
    }

    // 扩容指定数组，将 value 添加到尾部
    private static int[] appendArr(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
