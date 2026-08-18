package delete;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {
    static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement("DELETE FROM seller WHERE Name = ? ");
            st.setString(1, "Eduarda Barroso");

            int rows = st.executeUpdate();
            if(rows > 0) {
                System.out.println("Linhas afetadas: " + rows);
            } else {
                System.out.println("Nenhuma linha afeta");
            }
        } catch (DbException | SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
