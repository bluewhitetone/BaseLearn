package org.blue.nio.algo;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围：
 * 1
 * ≤
 * �
 * ≤
 * 1000
 * <p>
 * 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * <p>
 * 示例1
 * 输入：
 * ABCabc
 * A
 * 复制
 * 输出：
 * 2
 */
public class TargetStrTimes {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String sourceStr = scan.nextLine();
        String targetStr = scan.nextLine();
        String afterStr = sourceStr.toUpperCase().replaceAll(targetStr.toUpperCase(), "");
        System.out.println(sourceStr.length() - afterStr.length());

    }


}
