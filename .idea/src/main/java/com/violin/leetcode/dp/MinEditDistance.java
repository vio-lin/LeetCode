package com.violin.leetcode.dp;

import java.util.Scanner;

/**
 * NO 72
 * UNIX系统下有一个行编辑器ed，它每次只对一行文本做删除一个字符、插入一个字符或替换一个字符三种操作。例如某一行的内容是“ABC”，经过把第二个字符替换成“D”、删除第一个字符、末尾插入一个字符“B”，这三步操作后，内容就变成了“DCB”。即“ABC”变成“DCB”需要经过3步操作，我们称它们的编辑距离为3。
 * 现在给你两个任意字符串（不包含空格），请帮忙计算它们的最短编辑距离。
 * <p>
 * 输入描述:
 * 输入包含多组数据。
 * <p>
 * 每组数据包含两个字符串m和n，它们仅包含字母，并且长度不超过1024。
 * <p>
 * 输出描述:
 * 对应每组输入，输出最短编辑距离。
 * 示例1
 * 输入
 * ABC CBCD
 * ABC DCB
 * 输出
 * 2
 * 3
 * ————————————————
 */
public class MinEditDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] stringArray = line.split(" ");
            System.out.println(findMinDistance(stringArray[0], stringArray[1]));
        }
    }

    private static long findMinDistance(String string1, String string2) {
        int m = string1.length();
        int n = string2.length();
        int[][] dp = new int[m + 1][n + 1];
        // init
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        //遍历 我当前匹配到第几个 前面是最小的但是
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            int[] ints = array[i];
            for (int i1 = 0; i1 < ints.length; i1++) {
                System.out.print(String.format("%5d",ints[i1]));
            }
            System.out.println();
        }
    }
}
