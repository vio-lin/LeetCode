package com.violin.leetcode.dp;

import java.util.Scanner;

/**
 * NO 509
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *  
 *
 * 提示：
 *
 * 0 <= n <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Fabonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String string = scanner.nextLine();
            Integer no = Integer.valueOf(string);
            System.out.println(fib(no));
        }
    }

    public static int fib(int n) {
        if(n==0||n==1){
            return n;
        }

        int[] fibAarray = new int[]{0,1};
        for(int i =2;i<=n;i++){
            int temp = fibAarray[1];
            fibAarray[1] = fibAarray[1] + fibAarray[0];
            fibAarray[0] =temp;
        }
        return fibAarray[1];
    }
}
