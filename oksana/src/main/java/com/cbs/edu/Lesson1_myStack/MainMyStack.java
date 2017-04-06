package com.cbs.edu.Lesson1_myStack;

import java.util.EmptyStackException;
import java.util.Iterator;

public class MainMyStack {
    public static void main(String[] args) {
        MyStack <Integer>tmp = new MyStack<Integer>();
      //  tmp.push(78);
       // tmp.push(13);
       // tmp.push(14);
        //System.out.println(tmp.top);
        try {
            tmp.pop();
        }catch (EmptyStackException ex){
            System.out.println("The stack is empty");
        }
        // System.out.println(tmp.top);
        Iterator<Integer> iterator = tmp.iterator();

        while (iterator.hasNext()) {
            Integer i =  iterator.next();
            System.out.println(i);
        }

    }
}
