package emp_manage.main;
import java.sql.Connection; // interface
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionTest {
	public static void main(String[] args) {
//		Connection test
//		데이터베이스 연결 확인
//		1. Connection 정보 저장 변수 선언
//		driver, url(서버위치정보), id, password
//		localhost(내컴퓨터IP) : 오라클 서버의 IP Address
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "ora_user";
		String userpw = "1234";
		
		Connection con=null;
		
		try {
//			2. 드라이버 로딩 => 드라이버 클래스영역에 적재
			Class.forName(driver);
//			3. Connection new 생성
//			getConnection => return : Connection
			con = DriverManager.getConnection(url, userid, userpw);
			
//			4. select, insert , update, delete
			System.out.println("정상 연결");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			5. close()
			try {
				if(con != null) {
					con.close();
					System.out.println("연결 종료");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
