package test01;

import java.io.File;

public class fileList {
    public static void main(String[] args) {
        File dir = new File("c:\\front");
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            //String값임
            System.out.println(files[i].getName());
        }
    }
}
