package com.violin.leetcode.dp;

import java.util.Scanner;

/**
 * NO 322
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * 3
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String coninStr = scanner.nextLine();
            String[] split = coninStr.split(",");
            int[] coins = new int[split.length];
            for (int i = 0; i < coins.length; i++) {
                coins[i] = Integer.valueOf(split[i]);
            }

            String ammountStr = scanner.nextLine();
            int ammount = Integer.valueOf(ammountStr);

            System.out.println(coinChange(coins, ammount));
        }
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coinValue = coins[j];
                if (i - coinValue < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coinValue] + 1);

            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
