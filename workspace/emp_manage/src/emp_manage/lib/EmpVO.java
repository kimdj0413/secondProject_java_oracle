package emp_manage.lib;

import java.sql.Date;

/**
 * Description : 사원정보를 저장 처리하는 클래스 <br>
 * Date : 2024. 5. 10.<br>
 * History :<br>
 * - @author : e¹�e??i¤�<br>
 * - 날짜 : 2024. 5. 10.<br>
 * - 설명 : 최초작성 <br>
 * @version 1.0
 */

public class EmpVO {
   private String emp_id;
   private String emp_name;
   private String dept_no;
   private String dept_nm;
   private Date hire_dt;
public EmpVO(String emp_id, String emp_name, String dept_no, String dept_nm, Date hire_dt) {
	super();
	this.emp_id = emp_id;
	this.emp_name = emp_name;
	this.dept_no = dept_no;
	this.dept_nm = dept_nm;
	this.hire_dt = hire_dt;
}
public String getEmp_id() {
	return emp_id;
}
public void setEmp_id(String emp_id) {
	this.emp_id = emp_id;
}
public String getEmp_name() {
	return emp_name;
}
public void setEmp_name(String emp_name) {
	this.emp_name = emp_name;
}
public String getDept_no() {
	return dept_no;
}
public void setDept_no(String dept_no) {
	this.dept_no = dept_no;
}
public String getDept_nm() {
	return dept_nm;
}
public void setDept_nm(String dept_nm) {
	this.dept_nm = dept_nm;
}
public Date getHire_dt() {
	return hire_dt;
}
public void setHire_dt(Date hire_dt) {
	this.hire_dt = hire_dt;
}
@Override
public String toString() {
	return "[사원번호=" + emp_id + ", 사원이름=" + emp_name + ", 부서번호=" + dept_no + ", 부서명=" + dept_nm
			+ ", 입사일=" + hire_dt + "]";
}

}
