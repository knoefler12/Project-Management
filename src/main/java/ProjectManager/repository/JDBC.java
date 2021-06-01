package ProjectManager.repository;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
    //Database connection information
    private static String user;
    private static String pwd;
    private static String url;



    //Starts connection to database
    public static Connection JDBCconnect() throws SQLException {

        try (InputStream input = new ClassPathResource("application.properties").getInputStream()) {
            Properties properties = new Properties();
            properties.load(input);
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        DriverManager.getConnection(url,user,pwd);
        Connection conn = DriverManager.getConnection(url,user,pwd);
        return conn;
    }

}