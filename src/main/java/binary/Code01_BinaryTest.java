package binary;

import org.junit.Test;

/**
 * @author masun
 * @date 2021/12/4
 */
public class Code01_BinaryTest {

    @Test
    public void test1() {
        long l1 = System.currentTimeMillis();
        int[] arr = {1, 2, 44, 56, 11};
        for (int i = 0; i < 10; i++) {

            for (int i1 = 0; i1 < 100000000; i1++) {
                swap1(arr, 1, 2);
            }
        }
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", (l2 - l1) / 10);
    }

    public static void swap1(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void swap2(int[] arr, int a, int b) {

        arr[a] = arr[a] + arr[b];
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
    }

    public static void swap3(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
