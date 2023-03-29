package org.blue.nio.tree_set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(3);
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(2);
        treeSet.add(1);
        treeSet.add(5);

        Iterator<Integer> it = treeSet.iterator();
        while (it.hasNext()){
            Integer next = it.next();
            System.out.println(next);
        }
    }

}
