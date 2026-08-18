package recuperar_dados.application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class atividade {
    static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM seller");
            while(rs.next()) {
                System.out.println(rs.getString("Name") + " - " + rs.getString("Email") + " - " + rs.getDouble("BaseSalary"));
            }
            DB.closeResultset(rs);

            System.out.println("-----Desafio 2:------");
            rs = st.executeQuery("SELECT * FROM seller WHERE BaseSalary >= 3000.00");
            while(rs.next()) {
                System.out.println(rs.getString("Name") + " - " + rs.getString("Email") + " - " + rs.getDouble("BaseSalary"));
            }
            DB.closeResultset(rs);

            System.out.println("-----Desafio 3:------");
            rs = st.executeQuery("SELECT * From seller");
            while(rs.next()) {
                System.out.printf("Vendedor: [%s] | Departamento ID: [%d] %n", rs.getString("Name"), rs.getInt("DepartmentId"));
            }

        }catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultset(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
