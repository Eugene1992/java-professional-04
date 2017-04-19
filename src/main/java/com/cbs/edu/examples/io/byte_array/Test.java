package com.cbs.edu.examples.io.byte_array;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[]{72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33};
        String filePath = "C:\\Users\\Evgeniy\\Desktop\\java-professional-04\\src\\main\\java\\com\\cbs\\edu\\examples\\io\\byte_array\\file";
        InputStream in = new ByteArrayInputStream(buf);
        OutputStream out = new FileOutputStream(filePath);

        while (in.available() > 0) {
            int aByte = in.read();
            System.out.print((char)aByte);
            out.write(aByte);
        }

        out.close();
        in.close();
    }
}
