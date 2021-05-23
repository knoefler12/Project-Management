package ProjectManager.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
    private static String user;
    private static String pwd;
    private static String url;



    public static Connection JDBCconnect() throws SQLException {

        try (InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DriverManager.getConnection(url,user,pwd);
        Connection conn = DriverManager.getConnection(url,user,pwd);
        return conn;
    }

}