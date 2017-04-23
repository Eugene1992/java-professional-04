package com.cbs.edu.CountOfWordsInFile;

import java.io.FileReader;
import java.io.IOException;
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
     * @param textFromFile - contains all the text in the file
     */
    public static String fileReaderWithText(String pathToFile) {
        String textFromFile = null;
        try (FileReader reader = new FileReader(pathToFile)) {
            int position = -1;
            String word = null;
            while ((position = reader.read()) != -1) {
                char letter = (char) position;
                if (letterVerification(letter)) {
                    textFromFile = textFromFile + word + " ";
                    System.out.print(word + " ");
                    word = null;
                } else {
                System.out.print((char) position);
              word = word + ((char) position);
                }
            }


        } catch (IOException ex) {
            return ex.getMessage();
        }
        return  textFromFile;
    }

    public static boolean checkWithRegExp(String userNameString) {
        Pattern p = Pattern.compile("^[a-zA-Z-]");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public static boolean letterVerification(char letter) {
        String userNameString = String.valueOf(letter);
        Pattern p = Pattern.compile(">< !?,.");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}