package DemoClasses;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

/**
 * Created by admin on 10-09-2016.
 */
public class OraclStoredProcCall {

	public static void main(String args[]) {
		try {
			System.out.println("OracleDbConnection:main");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "krishnadb",
					"krishnadb");
			CallableStatement cs = connection
					.prepareCall("{call GET_EMPLOYEES(?,?)}");
			// Register the type of the IN/OUT parameter
			cs.setInt("EMP_NO_INPUT", 7839);
			cs.registerOutParameter("EMP_NAME_OUTPUT", Types.VARCHAR);

			cs.executeUpdate();
			String empName = cs.getString("EMP_NAME_OUTPUT");
			System.out.println("empName=>" + empName);

			connection.close();

		} catch (Exception e) {
			System.out.println(e);
		} finally {

		}

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			System.out.println("OracleDbConnection:main");
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "krishnaDB",
					"password");
		} catch (Exception e) {
			System.out.println(e);
		}

		return connection;
	}
}
