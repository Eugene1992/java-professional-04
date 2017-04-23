package com.cbs.edu.CountOfWordsInFile;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 23.04.17
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class CountOfWordsInFileTest {
    @Test
   public void ileReaderWithTextTest (){
       String a =CountOfWordsInFile.fileReaderWithText("C:\\Users\\Волк\\Desktop\\java-professional-04\\andrey\\src\\main\\java\\com\\cbs\\edu\\CountOfWordsInFile\\Game.of.Thrones.-.03x02.txt","C:\\Users\\Волк\\Desktop\\java-professional-04\\andrey\\src\\main\\java\\com\\cbs\\edu\\CountOfWordsInFile\\WordsExclude.txt");
      System.out.println(a);
    }
}
