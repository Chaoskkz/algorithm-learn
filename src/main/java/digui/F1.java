package digui;

/**
 * @author masun
 * @date 2021/12/4
 */
public class F1 {

    static int N = 100;
    static int[] arr = new int[N];
    static int[] cache = new int[N + 1];

    static {
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        cache[2] = 0;
        cache[3] = 1;
        cache[4] = 1;
    }

    public static int getA(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        if (sum % 2 == 1) {
            System.out.println("不可分");
            return -1;
        }
        return get(1);
    }

    public static int get(int sum) {
        return 1;
    }


}
