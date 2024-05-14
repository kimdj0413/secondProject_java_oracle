package emp_manage.lib;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	
//	Connection object return
	public static Connection getConnection() {
//	Connection 생성에 필요한 변수 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "ora_user";
		String userpw = "1234";
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, userpw);
			System.out.println("정상 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}	
}
