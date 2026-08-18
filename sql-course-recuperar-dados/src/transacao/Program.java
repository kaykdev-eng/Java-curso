package transacao;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

public class Program {
    static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            conn.setAutoCommit(false);

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 4000 WHERE DepartmentId = 2");

            int x = 1;
            if(x < 2) {
                throw new SQLException("Fake error");
            }
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 4900 WHERE DepartmentId = 1");

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused By: " + e1.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
