package com.cbs.edu.vladimir.hw_02;

import java.util.List;

/**
 * Created by Vladimir on 12.04.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>(6);

        System.out.println(myList.size());
//        myList.add(4);
        myList.addIndex(0, 1);
        myList.addIndex(1, 2);
        myList.addIndex(2, 3);
        myList.addIndex(3, 4);
        myList.addIndex(4, 5);
        myList.addIndex(5, 6);
        myList.addIndex(6, 7);
//        myList.add(1);
//
//        myList.add(5);
//        myList.add(11);
//        myList.add(1);
//        myList.add(8);
//        myList.add(4);
        System.out.println(myList);
//        System.out.println(myList.get(3));
    }
}
