package test05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class tryCatch {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream("c:/react/weather.html");
        }catch (FileNotFoundException e){
            throw  new RuntimeException();
        }catch (IOException e){
            throw  new RuntimeException();
        }finally {
            if(in != null){
                try{
                    in.close();
                }catch (IOException e){}
            }
        }
//        완벽한Perfect code
    }
}
