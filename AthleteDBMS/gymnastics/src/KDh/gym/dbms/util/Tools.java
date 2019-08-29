package KDh.gym.dbms.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Tools {


    /*private static final String dbconfig = "jdbc.properties";
    private static Properties prop = new Properties();
    static {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(dbconfig);
            prop.load(in);
            Class.forName(prop.getProperty("driverClassName"));
        } catch(IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(prop.getProperty("url"),
                    prop.getProperty("username"), prop.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
*/


    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://127.0.0.1:3306/gymdb?serverTimezone=GMT%2B8";
            //StudentManagementSystem

            return DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //关闭数据库
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException var2) {
                var2.printStackTrace();
            }
        }

    }
}
