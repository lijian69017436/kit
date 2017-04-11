package db.orcl.one;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrclTool {
	private OrclTool() {
	}

	public static OrclTool getOrclInstance() {
		return new OrclTool();
	}

	public Connection getconn() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
