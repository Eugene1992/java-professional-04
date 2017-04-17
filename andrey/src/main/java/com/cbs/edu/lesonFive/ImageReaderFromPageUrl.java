package com.cbs.edu.lesonFive;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ImageReaderFromPageUrl - write an API that should download all files from given URL to user file system.
 * Incoming args: URL(http://flangex.herokuapp.com/io/load), files extension, path for saving.
 */
public class ImageReaderFromPageUrl {
    //UrlFinder - selects URL from the line.
    public static void UrlFinder(String urlString){
        char[] charArr = urlString.toCharArray();
        for (int position=-1;position< charArr.length; position++ ){
            int TegLength= 7;
            String partString = "";
            for (int wordPartIndekator=-1; wordPartIndekator <TegLength; wordPartIndekator++){
                partString = partString+charArr[position+wordPartIndekator];
            }
            if (partString == "href=\""){
                int nomer = 0;
                String urlAddress = "";
                String element = "";
                int wordPartIndekator = position+TegLength;
                while (element == "\""){
                    element= String.valueOf(charArr[wordPartIndekator]);
                    wordPartIndekator++;
                   urlAddress = urlString+element;
        }
        FileImageUrl(urlAddress,nomer++);
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
            System.out.println(line);
            reader.close();
        } catch (Exception e) {
        }
        return (String)result.toString();
    }
    //Unloads a picture into a file from the transmitted value of the urlPage with the name number
   public static void FileImageUrl(String urlPage,int nomer){
       try {
           BufferedImage image =null;
           URL url = new URL(urlPage);
           image = ImageIO.read(url);
           if (image != null){
               ImageIO.write(image, "jpg",new File("C:\\Users\\Волк\\Desktop\\java-professional-04\\andrey\\src\\main\\java\\com\\cbs\\edu\\lesonFive"+nomer+".png"));
           }
       }
       catch (FileNotFoundException e) {
   } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
