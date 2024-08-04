package dataaccesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnect {
    private Connection connection;
    private static final String URL = "jdbc:sqlserver://TRANHUY\\SQLSEVER;databaseName=QLSV_TC;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    
    public dbConnect() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public ResultSet getData(String procName, Object[] param) {
        ResultSet rs = null;
        try {
            String sql = "{call " + procName + "(";
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    if (i > 0) {
                        sql += ",";
                    }
                    sql += "?";
                }
            }
            sql += ")}";
    
            PreparedStatement statement = connection.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    statement.setObject(i + 1, param[i]);
                }
            }
            rs = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }    

    public int executeSQL(String sql) {
        int rowsAffected = 0;
        try {
            Statement statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public int executeSQL(String procName, Object[] param) {
        int rowsAffected = 0;
        try {
            String sql = "{call " + procName + "(";
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    if (i > 0) {
                        sql += ",";
                    }
                    sql += "?";
                }
            }
            sql += ")}";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                statement.setObject(i + 1, param[i]);
            }
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

