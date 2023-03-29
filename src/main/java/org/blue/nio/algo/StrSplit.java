package org.blue.nio.algo;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class StrSplit {

    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            while (str.length() >= 8) {
                System.out.println(str.substring(0, 8));
                str = str.substring(8);
            }
            if (str.length() < 8 && str.length() > 0) {
                str = str + "0000000";
                System.out.println(str.substring(0, 8));
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String zeroStr = "00000000";
        int lenght = 8;
        String content = in.nextLine();

        if (content == null || content == "") {
            System.out.println(zeroStr);
        }

        int index = 0;
        while (index < content.length()) {
            if ((content.length() - index) >= 8) {
                System.out.println(content.substring(index, index + lenght));
            } else {
                String temp = content.substring(index, content.length()) + zeroStr;
                System.out.println(temp.substring(0, lenght));
            }
            index = index + lenght;
        }
    }
}
