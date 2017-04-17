package com.cbs.edu.leconFive;

import com.cbs.edu.lesonFive.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Волк
 * Date: 17.04.17
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
public class ImageReaderFromPageUrlTest {
    @Test
public void addWrongIndex(){
    String page = ImageReaderFromPageUrl.getHtmlPage("http://flangex.herokuapp.com/io/load");
        ImageReaderFromPageUrl.UrlFinder(page);
}
    @Test
public void FileImageUrlTest(){
        ImageReaderFromPageUrl.FileImageUrl("http://flangex.herokuapp.com/resources/img/io/load/img-01.png", 1);
    }
}

