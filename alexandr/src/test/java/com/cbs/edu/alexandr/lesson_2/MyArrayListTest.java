package com.cbs.edu.alexandr.lesson_2;

import com.cbs.edu.lesson_2.MyArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Герич on 11.04.2017.
 */
public class MyArrayListTest {
    private Integer valueOne;
    private Integer valueSecond;
    private MyArrayList<Integer> myArrayList;


    @Before
    public void setUp(){
    myArrayList = new MyArrayList<>();
        valueOne=1;
        valueSecond=3;
    }
    @Test
    public void addTest(){
        myArrayList.add(valueOne);
        myArrayList.add(1,valueSecond);
    }
    @Test
    public void removeTest(){
        myArrayList.add(valueOne);
        myArrayList.remove(0);
    }
    @Test
    public  void containsTest(){
        myArrayList.add(valueOne);
        myArrayList.contains(1);
    }
    @Test (expected = Exception.class)
    public void exceptionTest(){

    }
}
