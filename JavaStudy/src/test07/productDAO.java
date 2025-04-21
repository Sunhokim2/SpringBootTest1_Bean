package test07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class productDAO {

    List<productDTO> select(){
        productDTO product = new productDTO();


        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<productDTO> list = new ArrayList<productDTO>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            String url = "jdbc:mariadb://localhost:3306/java";
            String id = "root";
            String pw = "1234";

            // try - with - resources <- 자동  close()
            con = DriverManager.getConnection(url, id, pw);

            // SQL Injection 공격방법
            String sql = "select * from 제품";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id2 = rs.getInt("제품번호");
                String name = rs.getString("제품명");
                System.out.println(id2+name);

                product.setId(id2);
                product.setName(name);
                list.add(product);

                //주소값 공유되는거 때문에 늘 새롭게 선언해줘야한다.
                product = new productDTO();
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally{
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return list;
    }
}
