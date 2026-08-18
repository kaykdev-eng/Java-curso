package CRUD;

import db.DB;
import db.DbException;

import java.sql.*;

public class Program {
    static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        PreparedStatement st2 = null;
        PreparedStatement st3 = null;
        PreparedStatement st4 = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Inovação");
            int rows = st.executeUpdate();
            int newId = 0;
            if(rows > 0) {
                ResultSet resultKey = st.getGeneratedKeys();
                while (resultKey.next()) {
                    newId = resultKey.getInt(1);
                    System.out.println("Novo id cadastrado: " + newId);
                }
            } else {
                System.out.println("Algo de errado aconteceu, verifique os dados!");
            }

            st3 = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
            st3.setString(1, "Inovação & Tech");
            st3.setInt(2, newId);
            st3.executeUpdate();

            st2 = conn.prepareStatement("SELECT * FROM department");
            rs = st2.executeQuery();
            while(rs.next()) {
                System.out.printf("ID (%d) -- Name (%s) %n", rs.getInt("Id"), rs.getString("Name"));
            }

            st4 = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
            st4.setInt(1, newId);
            st4.executeUpdate();
        }catch (DbException | SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeStatement(st2);
            DB.closeStatement(st3);
            DB.closeStatement(st4);
            DB.closeResultset(rs);
            DB.closeConnection();
        }
    }
}
