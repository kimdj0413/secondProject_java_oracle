package emp_manage.lib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpService implements Empinterface{

	@Override
	public ArrayList<EmpVO> select() {
		String sql = "SELECT a.emp_id				"
					+ "	 , a.emp_name				"
					+ "	 , a.dept_no				"
					+ "	 , b.dept_nm				"
					+ "	 , a.hire_dt				"
					+ "  FROM emp a					"	
					+ "     , dept b				"
					+ " WHERE a.dept_no = b.dept_no	";
		ArrayList<EmpVO> empList = new ArrayList<EmpVO>();
		
		//데이터 베이스 연동
//		1. Connection
		Connection con = DBConnection.getConnection();
		try {
//			2. statement
			Statement stmt = con.createStatement();
//			3. stmt 실행 => select => ResultSet return
			ResultSet rs = stmt.executeQuery(sql);
//			4. ArrayList add <= new EmpVO
			while(rs.next()) {
				String emp_id = rs.getString("emp_id");
				String emp_name = rs.getString("emp_name");
				String dept_no = rs.getString("dept_no");
				String dept_nm = rs.getString("dept_nm");
				Date hire_dt = rs.getDate("hire_dt");
				EmpVO emp = new EmpVO(emp_id, emp_name, dept_no, dept_nm, hire_dt);
				empList.add(emp);
			}
			
			for(int i=0;i<empList.size();i++) {
				System.out.println(empList.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return empList;
	}

	@Override
	public ArrayList<EmpVO> select(String emp_name) {
		return null;
	}

	@Override
	public int insert(EmpVO empVO) {
		String sql = "INSERT INTO emp(emp_id, emp_name, dept_no) VALUES (?,?,?)";
		
		Connection con = DBConnection.getConnection();
		int cnt = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empVO.getEmp_id());
			pstmt.setString(2, empVO.getEmp_name());
			pstmt.setString(3, empVO.getDept_no());
			
			cnt = pstmt.executeUpdate();
			if (cnt == 1) {
				System.out.println("사원 추가");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int update(EmpVO empVO) {
		return 0;
	}

	@Override
	public int delete(String emp_id) {
		return 0;
	}

}
