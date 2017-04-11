package com.cbs.edu.leson;
import java.util.*;
import java.lang.*;
// MapSimbols - method, calculates the number of characters from the input string. Method to return an instance of Map.
public class MapSimbols {
    Scanner in = new Scanner(System.in);
    public String enterString;
    {
        System.out.println("Enter the string ");
        enterString = in.nextLine();

    Map map = new HashMap<Character, Integer>();
    for ( int i = -1; i < enterString.length(); i++ ) {
       int n = (int) map.get(enterString.charAt(i));
       map.put( enterString.charAt(i), ++n );
    }

    System.out.println(map);
}

}
