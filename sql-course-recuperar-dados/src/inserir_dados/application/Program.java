package inserir_dados.application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Eduarda Barroso");
            st.setString(2, "eduarda@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("26/11/2002").getTime()));
            st.setDouble(4, 2.560);
            st.setInt(5, 4);
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected);

            if(rowsAffected > 0) {
                ResultSet rsKey = st.getGeneratedKeys();
                while(rsKey.next()) {
                    int key = rsKey.getInt(1);
                    System.out.println(key);
                }
            }

            rs = st.executeQuery("SELECT * FROM seller");
            while(rs.next()) {
                System.out.println(rs.getString("Name") + " -- " + rs.getString("Email") + " -- " + rs.getDate("BirthDate"));
            }

        } catch (SQLException | ParseException e) {
            System.out.println(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultset(rs);
            DB.closeConnection();
        }
    }
}
