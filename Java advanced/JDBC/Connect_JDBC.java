package JDBC;

import java.sql.*;

public class Connect_JDBC {
    public Connect_JDBC() {
    }

    public static void main(String[] args) throws SQLException {
        // load the driver
//        try{
////            Class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
////            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        }catch(ClassNotFoundException cnfe){
//            System.out.println("Error loading driver: "+cnfe);
//        }
        // DefineTheConnectionURL
        String myURL = "jdbc:mysql://localhost:3306/sinhvien";
        String myURLtype_4 = "jdbc:jtds:sqlserver://localhost:80/sinhvien";
        // connect db
        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(myURL,username,password);
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        String productName = databaseMetaData.getDatabaseProductName();
        System.out.println("Database: "+ productName);
        String productVersion = databaseMetaData.getDatabaseProductVersion();
        System.out.println("Version: "+ productVersion);
        // Create a Statement
        Statement statement = connection.createStatement();
        // Execute a Query
        String query = "Select * from student";
        ResultSet resultSet = statement.executeQuery(query);
        // để cập nhập hoặc sửa đổi (modify) sử dụng phương thức executeUpdate (cho các câu lệnh  UPDATE ,INSERT,DELETE);
        String queryinsert = "insert student (hoten,namsinh,diachi) values (N'nguyễn thanh hải',1996,N'Hà Nội')";
      //  int rowEffect = statement.executeUpdate(queryinsert);
      //  System.out.println("Số dòng bị ảnh hươởng: "+ rowEffect);
        // để tạo hoặc xóa một bảng ta dùng phương thưc execute
        String queryCreateTable = "create table class ";
      //  statement.execute(queryCreateTable);
        // xử lý kết quả trả về
        while(resultSet.next()){
            System.out.println(resultSet.getString("id")+" "+resultSet.getString("hoten")+" "+resultSet.getString("namsinh")+" "+resultSet.getString("diachi"));

        }
        connection.close();
    }
}
