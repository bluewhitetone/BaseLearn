package org.blue.nio.algo;

import java.util.Scanner;

/**
 * 描述
 * 输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。(内存中是2进制)
 * <p>
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：
 * 输入一个整数（int类型）
 * <p>
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 * <p>
 * 示例1
 * 输入：6
 * 输出：2
 */
public class Times1InRadix2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String convertNum = Integer.toString(in.nextInt(), 2);
        char[] numArray = convertNum.toCharArray();
        int result = 0;
        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] == '1') {
                result++;
            }
        }
        System.out.println(result);
    }

}
