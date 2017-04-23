package com.cbs.edu.CountOfWordsInFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 23.04.17
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 */
public class CountOfWordsInFile {
    /**
     * FileReaderWithText - class returns a text variable into which it reads everything written into the file at the transmitted address
     *
     * @param pathToFile   - path to the file with text
     * @param wordsExclude - contains all the text in the file
     */
    public static String fileReaderWithText(String pathToFile, String wordsExclude) {
        Set exceptionSet = new HashSet<String>();
        String textFromFile = null;
        Map mapWord = new HashMap<String, Integer>();
        try (FileReader reader = new FileReader(wordsExclude)) {
            int position = 0;
            String word = "";
            while ((position = reader.read()) != -1) {
                word = word + ((char) position);
                if (letterVerification((char) position)) {
                    exceptionSet.add(word);
                    System.out.println(word);
                    word = "";
                } else {


                }

            }
        } catch (IOException ex) {

        }

        try (FileReader reader = new FileReader(pathToFile)) {
            int position = -1;
            String word = null;
            while ((position = reader.read()) != -1) {
                char letter = (char) position;
                if (letterVerification(letter)) {
                    if (checkWithRegExp(word) & word.compareTo("html") != 0 & word.compareTo("link") != 0 & word.compareTo("meta") != 0) {
                        int value = 1;
                        if (mapWord.containsKey(word)){
                            textFromFile = textFromFile + word + " ";
                             value = (int)mapWord.get(word);
                            mapWord.put(word,value+1);
                            System.out.print(word + " ");
                        } else
                            mapWord.put(word,1);
                    }
                    word = "";
                } else {
                    word = word + ((char) position);
                }
            }


        } catch (IOException ex) {

        }
        return textFromFile;
    }

    public static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[A-Za-z]{3,}");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public static boolean letterVerification(char letter) {
        String userNameString = String.valueOf(letter);
        Pattern p = Pattern.compile("[>< !?,.]");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}