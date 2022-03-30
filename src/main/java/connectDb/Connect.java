package connectDb;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connect {

    public Connection connect() {

        try {
            String url = "jdbc:mysql://localhost:3306/cuistoflem?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "toor";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            System.out.println("connected");
            return connection;
        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("ERROR");
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}