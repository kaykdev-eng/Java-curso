package inserir_dados.application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class atividade {
    static void main(String[] args) {
        Connection coon = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            coon = DB.getConnection();
            st = coon.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Carlos Andrade");
            st.setString(2, "carlos@gmail.com");
            st.setDate(3, new java.sql.Date(stf.parse("15/05/1998").getTime()));
            st.setDouble(4, 3200.0);
            st.setInt(5, 2);

            int rows = st.executeUpdate();
            if (rows > 0) {
                ResultSet rsKey = st.getGeneratedKeys();
                while(rsKey.next()) {
                    int key = rsKey.getInt(1);
                    System.out.println("Novo Vendedor Cadastrado com ID: " + key);
                }
            }
            PreparedStatement st2 = coon.prepareStatement("SELECT * FROM seller");
            rs = st2.executeQuery();
            while(rs.next()) {
                System.out.printf("Nome: %s -- Email: %s -- BirthDate: %tc -- BaseSalary: %f -- Departament Id: %d %n", rs.getString("Name"), rs.getString("Email"), rs.getDate("BirthDate"), rs.getDouble("BaseSalary"), rs.getInt("DepartmentId"));
            }
        } catch (DbException | SQLException | ParseException e) {
            System.out.println(e.getMessage());
        } finally {
            DB.closeResultset(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
