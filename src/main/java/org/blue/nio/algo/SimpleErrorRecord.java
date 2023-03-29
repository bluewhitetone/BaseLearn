package org.blue.nio.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * HJ19 简单错误记录
 */
public class SimpleErrorRecord {


    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        ArrayList<String> errKeyList = new ArrayList<String>();
        ArrayList<Integer> errValueList = new ArrayList<Integer>();


        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String[] b = a.split(" ");
            String c2 = "";
            // 有\就截取，没有就原封不动
            if (b[0].indexOf("\\") != -1) {
                c2 = b[0].substring(b[0].lastIndexOf("\\") + 1, b[0].length());
            } else {
                c2 = b[0];
            }

            start = 0;

            if (c2.length() > 16) {
                start = c2.length() - 16;
                c2 = c2.substring(start, c2.length());
            }
            String d = c2 + " " + b[1];
            Integer pos = hm.get(d);
            if (pos == null) {
                hm.put(d, errKeyList.size());
                errKeyList.add(d);
                errValueList.add(1);
            } else {
                errValueList.set(pos, errValueList.get(pos) + 1);
            }
        }
        start = 0;
        if (errKeyList.size() > 8) start = errKeyList.size() - 8;
        for (int i = start; i < errKeyList.size(); i++) {
            String keyString = errKeyList.get(i);
            String[] keyArray = keyString.split(" ");
            System.out.print(keyArray[0]);
            System.out.print(" ");
            System.out.print(keyArray[1]);
            System.out.print(" ");
            System.out.println(errValueList.get(i));
        }
    }
}
