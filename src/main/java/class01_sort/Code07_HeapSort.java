package class01_sort;

/**
 * @author masun
 * @date 2021/12/5
 */
public class Code07_HeapSort {

    public static void main(String[] args) {
        int[] arr = RanArr.ran(10000000, 100000000);
        long l1 = System.currentTimeMillis();
        sort(arr);
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1));
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int end = len;

        // 先构建大顶堆
        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            end--;
            adjustHeap(arr, 0, end);
        }
    }

    // 构建大顶堆
    private static void buildMaxHeap(int[] arr, int len) {
        // 最后一个非 叶子结点 索引至多 为 len/2 - 1  ，为啥？ 因为
        //  1、2n 个结点，第 n 个结点 子结点为 2n+1 和 2n+2
        //  2、2n + 1 个结点，第 n 个结点 子结点为 2n+1 和 2n+2
        // 因为索引 从 0 开始，-1
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }
    }

    // 调整堆结点
    private static void adjustHeap(int[] arr, int i, int len) {
        // 左、右子结点
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 三个结点中，最大结点 的 索引下标
        int largestIndex = i;

        if (left < len && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }

        if (right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        // 最大值不是父结点
        if (largestIndex != i) {
            swap(arr, i, largestIndex);

            // 因为交换了 父子节点，新子结点后的堆结构被破坏
            // largestIndex 是被交换的子结点 的索引
            // 对 该子结点 下的堆结构进行重排
            adjustHeap(arr, largestIndex, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
