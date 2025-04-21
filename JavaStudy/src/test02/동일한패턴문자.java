package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 동일한패턴문자 {
    public static void main(String[] args) throws IOException {
        String address = "http://ggoreb.com/quiz/pattern.html";
        URL url = new URL(address);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
        String text = "";
        String data;
        while ((data = in.readLine()) != null) {
            text += data;
        }
        text = text.substring(text.lastIndexOf("<!--"));

        Pattern p = Pattern.compile("[a-z][A-Z]{3}([a-z]{1})[A-Z]{3}[^A-Z]");
        Matcher m = p.matcher(text);

        while (m.find()) {
            String result = m.group();
            System.out.println(result);
        }
    }
}
