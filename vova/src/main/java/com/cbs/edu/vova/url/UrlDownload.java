package com.cbs.edu.vova.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * Program which download html using URL and load all images from refferences.
 */
public class UrlDownload {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://flangex.herokuapp.com/io/load");
        String[] siteSplit = String.valueOf(url).split(".com");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("D:\\java-professional-04\\vova\\src\\main\\java\\com\\cbs\\edu\\vova\\url\\index.html")
                )
        );
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            out.write(inputLine);
        }
        out.close();
        in.close();
        File file = new File("D:\\java-professional-04\\vova\\src\\main\\java\\com\\cbs\\edu\\vova\\url\\index.html");
        Document doc = Jsoup.parse(file, "UTF-8", "http://example.com/");
        Elements elements = doc.getElementsByAttribute("href");
        boolean noImg= false;
        for (Element elem : elements) {
            String[] linkSplit = String.valueOf(elem.attr("href")).split("/");
            for (String linkPart : linkSplit) {
                noImg = false;
                if (linkPart.equals("css")) {
                    noImg = true;
                    break;
                }
            }
            if(!noImg){
                loadImage("D:\\java-professional-04\\vova\\src\\main\\java\\com\\cbs\\edu\\vova\\url\\" + elem.html() + ".png", siteSplit[0] + ".com" + elem.attr("href"));
            }
        }
    }

    /** Method which load image using URL.
     * @param name The name of saved image.
     * @param url  URL where program can find this image.
     * @return img.
     */
    private static Image loadImage(String name, String url) {
        try {
            String fileName = name;
            BufferedImage img = ImageIO.read(new URL(url));
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            ImageIO.write(img, "png", file);
            return img;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
