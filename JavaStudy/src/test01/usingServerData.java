package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLEncoder;

public class usingServerData {
    public static void main(String[] args) throws IOException {
        String word = URLEncoder.encode("소나기", "UTF-8");
        String address = "http://ggoreb.com/quiz/"+word+".txt";


        URL url = new URL(address);
        // 한글자씩 데이터 읽어오기
        InputStream in = url.openStream();
        // Stream을 Reader로 변환
        InputStreamReader isr = new InputStreamReader(in, "euc-kr");
        // 한줄 씩 데이터 읽어오기(BufferedReader)
        BufferedReader reader = new BufferedReader(isr);

        String text = "";
        while(true){
            String data = reader.readLine();
            if(data == null){
                break;
            }
            text += data + "\n";
        }
        System.out.println(text);
    }
}
