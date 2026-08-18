package recuperar_dados.application;

import db.DB;

import java.sql.Connection;

public class Program {
    static void main() {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
