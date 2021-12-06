package digui;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author masun
 * @date 2021/12/4
 */
public class F3 {
    // d[i][j] 表示 重量固定，前 i 件物品 中的最佳选择

    // 1、装不下，dp[i][j] = dp[i-1][j], 装不下 w[i] > j

    // 2、能装 ，判断 不装 和 装的 价值
    // dp[i][j] = max{ dp[i-1][j] , dp[i][j - w[i]] + p[i]} ，w[i]<=j

    public static void f() {
        int[] w = {11, 14, 13, 12, 16, 18, 10, 16};//物品的重量
        int[] p = {1500, 3000, 2000, 2999, 1000, 2222, 888, 1234}; //物品的价值
        int m = 82; //背包的容量
        int n = p.length; //物品的个数


        //创建二维数组，
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] dp = new int[n + 1][m + 1];
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行和第一列, 这里在本程序中，可以不去处理，因为默认就是0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; //将第一列设置为0
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; //将第一行设置0
        }


        //根据前面得到公式来动态规划处理
        for (int i = 1; i < dp.length; i++) { //不处理第一行 i是从1开始的
            for (int j = 1; j < dp[0].length; j++) {//不处理第一列, j是从1开始的
                //公式
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
                    if (dp[i - 1][j] < p[i - 1] + dp[i - 1][j - w[i - 1]]) {
                        dp[i][j] = p[i - 1] + dp[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
        }

        //输出一下v 看看目前的情况
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("============================");
        //动脑筋
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while (i > 0 && j > 0) { //从path的最后开始找
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1]; //w[i-1]
            }
            i--;
        }
    }

    static int[] w = {11, 14, 13, 12, 16, 18, 10, 16};//物品的重量
    static int[] p = {1500, 3000, 2000, 2999, 1000, 2222, 888, 1234}; //物品的价值

    static int W = 100;
    static int dp0[][] = new int[w.length + 1][W + 1];

    public static int fin(int i, int j) {
        if (i < 1 || j < 1) {
            return 0;
        }
        if (dp0[i][j] != 0) {
            return dp0[i][j];
        }
        if (w[i - 1] > j) {
            dp0[i][j] = fin(i - 1, j);
        } else {
            dp0[i][j] = Math.max(fin(i - 1, j), fin(i - 1, j - w[i - 1]) + p[i - 1]);
        }

        return dp0[i][j];
    }

    static class WuPin{
        int w;
        int p;

    }

}
