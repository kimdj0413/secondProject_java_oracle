package emp_manage.lib;

import java.util.ArrayList;

public interface Empinterface {
//	1. 사원 목록 조회
	public ArrayList<EmpVO> select();
	
//	2. 사원 이름 검색
	public ArrayList<EmpVO> select(String emp_name);
	
//	3. 사원 추가
	public int insert(EmpVO empVO);
	
//	4. 사원 수정
	public int update(EmpVO empVO);
	
//	5. 사원 삭제
	public int delete(String emp_id);
	
}
