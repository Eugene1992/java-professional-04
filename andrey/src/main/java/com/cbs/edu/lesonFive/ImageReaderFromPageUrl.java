package com.cbs.edu.lesonFive;
/**
 * ImageReaderFromPageUrl - write an API that should download all files from given URL to user file system.
 * Incoming args: URL(http://flangex.herokuapp.com/io/load), files extension, path for saving.
 */

import javax.imageio.ImageIO;
import java.net.MalformedURLException;
import java.io.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class ImageReaderFromPageUrl {
    /**UrlFinder - selects URL from the line.
     */
     public static void urlFinder(String urlString) {
        char[] charArr = urlString.toCharArray();
        String tegLength = "href=\"";
        for (int position = 0; position < (charArr.length - tegLength.length()); position++) {
            String partString = "";
            String letter = "a";
            for (int wordPartIndekator = 0; wordPartIndekator < tegLength.length(); wordPartIndekator++) {
                letter = String.valueOf(charArr[position + wordPartIndekator]);
                partString = partString.concat(letter);
                if (partString.equals(tegLength)) {
                    String urlAddress = "http://flangex.herokuapp.com/";
                    String element = "";
                    int indekator = position + tegLength.length();
                    do {

                        element = String.valueOf(charArr[indekator]);
                        if (element.equals("\"")){
                            break;
                        }
                        indekator++;
                        urlAddress = urlAddress + element;
                    } while (!element.equals("\""));
                    fileImageUrl(urlAddress, position);
                }

            }
        }
    }

    public static String getHtmlPage(String urlString) {
        StringBuilder result = new StringBuilder();
        String line;
        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null)
                result.append(line);
            reader.close();
        } catch (Exception e) {
        }
        return result.toString();
    }

    /**Unloads a picture into a file from the transmitted value of the urlPage with the name number
     */
     public static void fileImageUrl(String urlPage, int nomer) {
        try {
            BufferedImage image = null;
            URL url = new URL(urlPage);
            image = ImageIO.read(url);
            if (image != null) {
                ImageIO.write(image, "jpg", new File("C:\\Users\\Волк\\Desktop\\java-professional-04\\andrey\\src\\main\\java\\com\\cbs\\edu\\lesonFive" + nomer + ".png"));
            }
        } catch (FileNotFoundException e) {
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
