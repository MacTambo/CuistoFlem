package connectDb;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//844
public class Connect {
    public Connection connect() {
        try{
            String url = "jdbc:mysql://localhost:3306/cuistoflem";
            String user = "root";
            String password = "toor";

            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            System.out.println("connected");
            return connection;

        } catch (SQLException e) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("ERROR");
        }
        return null;
    }
}