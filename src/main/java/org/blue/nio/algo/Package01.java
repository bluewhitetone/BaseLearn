package org.blue.nio.algo;

import java.util.Arrays;

/**
 * 物品 重量 价值
 * 物1   1   15
 * 物2   3   20
 * 物3   4   30
 * <p>
 * 背包最大容量为4
 */
public class Package01 {

    public static void main(String[] args) {
        package02();
    }

    public static void package01() {
        int maxWeight = 4;
//        int[] weight = {1, 3, 4};
//        int[] value = {15, 20, 30};
        int[] weight = {4, 3, 1};
        int[] value = {30, 20, 15};

        // 循环时, 需要从物品1和重量1开始取, 这样才有意义, 所以横竖都增加1, 初始为0
        int[][] dp = new int[3 + 1][maxWeight + 1];

        // 初始化容量为0时, 默认值
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }

        // 初始化物0时, 默认值
        Arrays.fill(dp[0], 0);


        // 不放物品i时, 价值
        // dp[i][j] = dp[i-1][j]

        // 放物品i时, 价值
        // dp[i][j] = dp[i-1][j-weight[i]]+value[i]

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 当前容量减去物品i的重量刚好或者还有余量, 说明能放入
                if (j - weight[i - 1] >= 0) {
                    // 能放入, 不代表一定要放入, 要判断放入这个物品, 和不放这个物品, 哪个价值最大, 取最大值
                    // (不放的话, 就是取上一个物品放或者不放的最大值)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    // 不放入, 那就等于上一个的值
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        printArray(dp);

    }

    public static void printArray(int[][] dp) {
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + ", ");
            }
            System.out.println();
        }
    }

    public static void package02() {
        int bagSize = 4;
        int[] weight = {4, 3, 1};
        int[] value = {30, 20, 15};

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }

        // print
        for (int i : dp) {
            System.out.print(i + ", ");
        }
    }


}
