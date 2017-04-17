package com.cbs.edu.lesonFive;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ImageReaderFromPageUrl - write an API that should download all files from given URL to user file system.
 * Incoming args: URL(), files extension, path for saving.
 */
public class ImageReaderFromPageUrl {
    public static String get(String urlString) {
        StringBuilder result = new StringBuilder();
        String line;
        try {
            URL url = new URL("http://flangex.herokuapp.com/io/load");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null)
                System.out.println(line);
                result.append(line);
                reader.close();
        } catch (Exception e) {

        }

        return result.toString();
    }

}
