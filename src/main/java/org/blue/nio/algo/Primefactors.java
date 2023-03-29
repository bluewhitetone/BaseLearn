package org.blue.nio.algo;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 */
public class Primefactors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int base = 2;
        int num = in.nextInt();

        if (num < base) {
            System.out.printf(num+"");
            return;
        }

        while (num != 1) {
            if (num % base == 0) {
                System.out.print(base + " ");
                num = num / base;
            } else {
                if (base > num / base) {
                    base = num;
                } else {
                    base++;
                }
            }
        }
    }


}
