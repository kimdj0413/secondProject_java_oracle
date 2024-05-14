package emp_manage.main;
import java.sql.Connection;
import java.sql.SQLException;
import emp_manage.lib.DBConnection;
import emp_manage.lib.EmpService;
import emp_manage.lib.EmpVO;

public class DbconnTest {
	public static void main(String[] args) {
//		사원목록(select)
		EmpService empService = new EmpService();
		empService.select();
		
//		insert
		String emp_id = "20240002";
		String emp_name = "마이꼴";
		String dept_no = "01";
		
		EmpVO emp = new EmpVO(emp_id, emp_name, dept_no, null, null);
		empService.insert(emp);
		
		empService.select();
	}
}