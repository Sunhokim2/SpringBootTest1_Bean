package test02;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class json {
    public static void main(String[] args) throws IOException {
        String[] names = {"우하하", "이히히", "소장님"};
        ObjectMapper om = new ObjectMapper();

        String json = om.writeValueAsString(names);
        System.out.println(json);

        String address = "http://ggoreb.com/api/lotto.jsp";
        URL url = new URL(address);
        Map map = om.readValue(url, Map.class);
        System.out.println(map);
    }
}
