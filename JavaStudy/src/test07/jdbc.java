package test07;

import java.sql.*;
import java.util.List;

/**
 * 자바에서 DB 연결하는 코드 - 마리아DB를 연결했습니다.
 */
public class jdbc {
    public static void main(String[] args) {
        productDAO dao = new productDAO();
        List<productDTO> list = dao.select();

        System.out.println(list);



    }
}
