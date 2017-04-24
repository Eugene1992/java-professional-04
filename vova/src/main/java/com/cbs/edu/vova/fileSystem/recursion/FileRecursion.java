package com.cbs.edu.vova.fileSystem.recursion;

import java.io.*;

/**
 * Created by DarKnight on 017 17.04.17.
 */
public class FileRecursion {

    private String path;
    private String str;

    public FileRecursion(String path, String str) {
        this.path = path;
        this.str = str;
    }

    /**
     * Method which find all files and directories.
     */

    public void find() {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                writeUsingFileWriter(f.getPath() + ": ");
                this.path = f.getPath();
                find();
            } else {
                if (f.isFile()) {
                    this.path = f.getParent();
                    writeUsingFileWriter(f.getName());
                }
            }
        }
    }

    /**
     * Method which write string to the file.
     *
     * @param data string ith information.
     */
    private static void writeUsingFileWriter(String data) {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\cbs\\edu\\vova\\fileSystem\\recursion\\files.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(data);
            fr.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
