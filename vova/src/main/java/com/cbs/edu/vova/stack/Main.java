package com.cbs.edu.vova.stack;

import java.util.Iterator;
import java.util.Random;

/**
 *Main class which contain examples.
 */
public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<Integer>();
        stack.createStack(10);
        Random rand = new Random();
        while (!stack.isFull())
        {
            stack.push(rand.nextInt(100));
        }

        Iterator<Integer> iterator = stack.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("===========");

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
