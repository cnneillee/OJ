package cn.neillee.utils;

/**
 * Created by Neil on 2017/8/7.
 * 01背包问题：此处的01表示的是，对于每个商品的放入问题，只存在放入或者放入的情况，而不用考虑放入不放入、放入多少个的问题。
 */
public class BooleanBackPack {

    /**
     * @param maxWeight 背包的最大容量
     * @param count     物品的数量
     * @param weight    物品的重量数组
     * @param value     物品的价值数组
     * @return 解决方案
     */
    public static int[][] solve(int maxWeight, int count, int[] weight, int[] value) {
        int[][] result = new int[count + 1][maxWeight + 1];
        for (int i = 0; i < count + 1; i++) result[i][0] = 0;
        for (int i = 0; i < maxWeight + 1; i++) result[0][i] = 0;

        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {
                // 根据状态转换方程：f[i][j] = max{f[i-1][j], f[i-1][j-weight[i]] + value[i]}
                // f[i][j]：当背包的容量为 j 时，对于 i 件物品的最优方案有如下两种情况
                //1.第 i 件物品的重量大于背包的容量(weight[i-1]>j)，则f[i][j]=f[i-1][j]
                //2.否则：a.若第 i 件物品不放入背包，则f[i][j]=f[i-1][j]；
                //       b.若第 i 件物品放入背包，放入 i 件物品前背包剩余重量为 j-weight[i-1]，则f[i][j]=f[i-1][j-weight[i-1]]+value[i-1]
                if (weight[i - 1] > j) {// 后项不存在
                    result[i][j] = result[i - 1][j];
                } else {// 后项存在
                    int pre = result[i - 1][j];
                    int post = result[i - 1][j - weight[i - 1]] + value[i - 1];
                    result[i][j] = pre > post ? pre : post;
                }
            }
        }
        return result;
    }
}
