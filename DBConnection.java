import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/elderlies_home";
        String user = "root";
        String password = "root 123";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }
}

