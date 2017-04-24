package com.cbs.edu.vova.regular;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular expressions.
 */
public class RegEx {
    public static void main(String[] args) throws FileNotFoundException {
        String str = readFile(System.getProperty("user.dir") + "\\vova\\src\\main\\java\\com\\cbs\\edu\\vova\\regular\\Game.of.Thrones.-.03x02.txt");
        str = replace(str, "<i>", "");
        str = replace(str, "</i>", "");
        str = replace(str, "[-<>,/?():!.]*","");
        str = replace(str, "[ ]{2,4}"," ");
        System.out.println(str);
        String[] words = str.split("[ ]");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap = wordsCounter(words);
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        for (Map.Entry<String, Integer> element : set) {
            System.out.print(element.getKey() + ": ");
            System.out.println(element.getValue());
        }
        System.out.println("Amount of words = " + words.length);
        System.out.println("Amount of unique words = " + uniqueWordsCounter(hashMap));
    }

    public static String readFile(String fileName) throws FileNotFoundException {
        //Этот спец. объект для построения строки
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    boolean match = match(s);
                    if (match) {
                        sb.append(s);
                        sb.append(" ");
                    }
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }

    public static boolean match(String str) {
        Pattern p = Pattern.compile("[-a-zA-Z <>,/?():!.]*");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static String replace(String str, String pattern, String replaceString) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        return m.replaceAll(replaceString);
    }

    public static HashMap wordsCounter(String[] words) throws FileNotFoundException {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int value;
        for (String word : words) {
            if (word.length() >= 3) {
                if (!checkWordForExcceptions(word)) {
                    if (hashMap.get(word) == null) {
                        hashMap.put(word, 1);
                    } else {
                        value = hashMap.get(word);
                        hashMap.put(word, value + 1);
                    }
                }
            }
        }
        return hashMap;
    }

    public static int uniqueWordsCounter(HashMap hashMap) {
        int count = 0;
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        for (Map.Entry<String, Integer> element : set) {
            if (element.getValue() == 1) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkWordForExcceptions(String word) throws FileNotFoundException {
        String exc = readFile(System.getProperty("user.dir") + "\\vova\\src\\main\\java\\com\\cbs\\edu\\vova\\regular\\Exception words.txt");
        String[] exceptions = exc.split(" ");
        for (String exception : exceptions) {
            if (word.equals(exception)) {
                return true;
            }
        }
        return false;
    }
}
