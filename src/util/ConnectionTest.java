package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {

    public static void main(String[] args) {
        try {
            Connection con = DatabaseConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("DESCRIBE appointments");

            while (rs.next()) {
                System.out.println(rs.getString("Field"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}