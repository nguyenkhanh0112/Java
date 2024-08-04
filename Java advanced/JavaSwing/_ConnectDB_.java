package JavaSwing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _ConnectDB_ {
    private static final String URL = "jdbc:mysql://MySQL Sever:3306/sinhvien";
    private static final String USENAME = "root";
    private static final String PASSWORD = "123456";
    public _ConnectDB_(){
    }
    public static Connection getConnect(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL,USENAME,PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}
