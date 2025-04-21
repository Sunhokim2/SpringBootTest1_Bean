package test06;

import java.io.FileInputStream;
import java.io.InputStream;

public class ThreadTestinput {
    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("byte-stream-data.txt");

        int letter = in.read();
        System.out.printf("ASCII 값 : %s\n", letter);
        System.out.printf("문자형태로 변환된 값 %s\n", (char)letter);

        letter = in.read();
        System.out.printf("ASCII 값 : %s\n", letter);
        System.out.printf("문자형태로 변환된 값 %s\n", (char)letter);


        //
    }
}
