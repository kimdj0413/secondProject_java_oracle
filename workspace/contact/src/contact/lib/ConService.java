package contact.lib;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConService implements Coninterface {
	Connection connect = DBConnection.getConnection();
	Query query = new Query();
	Exceptions exceptions = new Exceptions();
	Scanner scan = new Scanner(System.in);
	String sql;
	String number;
	String relation;
	
	public ArrayList<ConVO> getConVO() throws SQLException {
		ArrayList<ConVO> conList = new ArrayList<ConVO>();
		Statement stmt = connect.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String con_id = rs.getString("con_id");
			String con_nm = rs.getString("con_nm");
			String con_num = rs.getString("con_num");
			String rel_nm = rs.getString("rel_nm");
			String con_rel = rs.getString("con_rel");
			String con_add = rs.getString("con_add");
			String con_dt = rs.getString("con_dt");
			ConVO con = new ConVO(con_id, con_nm, con_num, rel_nm, con_rel, con_add, con_dt);
			conList.add(con);
		}
		
		for(int i=0;i<conList.size();i++) {
			System.out.println((i+1)+". "+conList.get(i));
		}
		return conList;
	}
	@Override
	public void select() {
		sql = query.select();
		try {
			getConVO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert() {
		ConVO con = new ConVO(null, null, null, null, null, null, null);
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine();
		while(true) {
			System.out.print("번호를 입력하세요 : ");
			number = scan.nextLine();
			if(exceptions.NumberException(number) ==1) {
				break;
			}
		}
		while(true) {
			sql = query.relation();
			ArrayList<String> list = new ArrayList <String>();
			try {
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				System.out.print("[ ");
				while(rs.next()) {
					System.out.print(rs.getString("rel_nm")+" ");
					list.add(rs.getString("rel_nm"));
				}
				System.out.print("]");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.print("를 입력하세요 : ");
			relation = scan.nextLine();
			if(exceptions.RelationException(relation, list) ==1) {
				break;
			}
		}
		System.out.print("주소를 입력하세요 : ");
		String address = scan.nextLine();
		
		sql = query.relation();
		
		try {
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(rs.getString("rel_nm").equals(relation)) {
					relation = rs.getString("rel_no");
				}
			}
			con = new ConVO(null, name, number, null, relation, address, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "INSERT INTO contact(con_id, con_nm, con_num, con_rel, con_add) VALUES (get_seq_id(),?,?,?,?)";
		int cnt = 0;
		try {
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setString(1, con.getCon_nm());
			pstmt.setString(2, con.getCon_num());
			pstmt.setString(3, con.getCon_rel());
			pstmt.setString(4, con.getCon_add());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		System.out.print("수정할 사람 이름을 입력하세요 : ");
		String name = scan.nextLine();
		name = "%"+name+"%";
		sql = query.find(name);
		try {
			getConVO();
			System.out.print("몇번째를 수정할까요?");
			int num = scan.nextInt();
			String id = getConVO().get(num-1).getCon_id();
			sql = "DELETE FROM CONTACT WHERE CON_ID = ?";
			int cnt = 0;
			try {
				PreparedStatement pstmt = connect.prepareStatement(sql);
				pstmt.setString(1, id);
				
				cnt = pstmt.executeUpdate();
				if (cnt == 1) {
					insert();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		System.out.print("삭제할 사람 이름을 입력하세요 : ");
		String name = scan.nextLine();
		sql = query.find(name);
		try {
			ArrayList<ConVO> conList = new ArrayList<ConVO>();
			conList = getConVO();
			System.out.print("몇번째를 삭제할까요?");
			int num = scan.nextInt();
			String id = conList.get(num-1).getCon_id();
			sql = "DELETE FROM CONTACT WHERE CON_ID = ?";
			try {
				PreparedStatement pstmt = connect.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void end() {
		System.out.println("변경 사항을 저장하시겠습니까(Y/N)? ");
		String save = scan.nextLine();
		if (save.equals("Y")) {
			String sql = "COMMIT";
			try {
				PreparedStatement pstmt = connect.prepareStatement(sql);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				try {
					connect = null;
					if(connect != null) {
						connect.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void addRelation() {
		System.out.print("어떤 관계를 추가할까요? ");
		String relation = scan.nextLine();
		sql = "INSERT INTO relation VALUES (get_rel_no(), ?)";
		try {
			PreparedStatement pstmt = connect.prepareStatement(sql);
			pstmt.setString(1, relation);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}