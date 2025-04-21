package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class findWord {
    public static void main(String[] args) throws IOException {
        String name = URLEncoder.encode("운수좋은날", "utf-8");
        String address =
                "http://ggoreb.com/quiz/" + name + ".txt";
        URL url = new URL(address);
        InputStream in = url.openStream();
        InputStreamReader isr = new InputStreamReader(in, "euc-kr");
        BufferedReader reader = new BufferedReader(isr);

        String text = "";
        while(true) {
            String data = reader.readLine(); // 한줄씩 데이터 가져오기
            if(data == null) break; // 읽어올 데이터가 없으면 종료
            text += data + "\n";
        }
        text = text.substring(text.lastIndexOf("<!--"));

        Pattern p = Pattern.compile("[a-zA-Z가-힣0-9]");
        Matcher m = p.matcher(text);

        while (m.find()) {
            String result = m.group(1);
            System.out.print(result);
        }
    }
}

