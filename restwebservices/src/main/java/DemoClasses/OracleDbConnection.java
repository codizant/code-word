package DemoClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by admin on 10-09-2016.
 */
public class OracleDbConnection {

    public static void main(String args[]){
        try{        	
            System.out.println("OracleDbConnection:main");
            Class.forName("oracle.jdbc.driver.OracleDriver");

           // Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root"); 
            //String sql ="SELECT ID, NAME FROM EMPLOYEE";  // for sql server
           // Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
            
            Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","krishnadb","krishnadb");
            String sql = "select EMPNO,ENAME from emp"; // For Oracle
            Statement statement=connection.createStatement();
            
            ResultSet resultSet=statement.executeQuery(sql); //"select * from emp"
            
            while (resultSet.next()) {
            	// Note: column name as per Oracle/Sql server
                System.out.println(resultSet.getInt("EMPNO") + "  " + resultSet.getString("ENAME"));
            }
            
            
            connection.close();
            
        }catch(Exception e){ System.out.println(e);}
        
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println("OracleDbConnection:main");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "krishnaDB", "password");
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
}
