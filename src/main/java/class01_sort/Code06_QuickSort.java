package class01_sort;

/**
 * 快速排序
 * @author masun
 * @date 2021/12/5
 */
public class Code06_QuickSort {
    public static void main(String[] args) {
        int[] arr = RanArr.ran(10000000, -100000000, 100000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (right > left) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    // 计算 arr 由 left 到 right 子数组 快速排序后 基准值 pivot
    private static int partition(int[] arr, int left, int right) {
        // 以 a[left] 为基准值
        int pivotValue = arr[left];

        // 关键变量，记录已出现的 大于 pivotValue 的 元素数量（它们是连续的）
        // 表示如果 当前元素 小于基准值，那么它前面有 da 个大数，即交换要与最前面的大数 交换 即 swap(i,i-da)
        // 考虑到 比较长时，da 几乎不可能长时间 为 0，所以 swap 前不进行判断，自交换开销可能更小
        int da = 0;
        // 从基准值后一位开始
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] <= pivotValue) {
                swap(arr, i, i - da);
            } else {
                // 这个数是 大数
                da++;
            }
        }
        // 最后，基准值 与 a[rigth - da] 交换
        swap(arr, left, right - da);
        return right - da;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
