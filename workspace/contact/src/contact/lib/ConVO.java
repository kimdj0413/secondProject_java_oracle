package contact.lib;
import java.sql.Date;

public class ConVO {
	private String con_id;
	private String con_nm;
	private String con_num;
	private String rel_nm;
	private String con_rel;
	private String con_add;
	private String con_dt;
	
	public ConVO(String con_id, String con_nm, String con_num, String rel_nm, String con_rel, String con_add,
			String con_dt) {
		super();
		this.con_id = con_id;
		this.con_nm = con_nm;
		this.con_num = con_num;
		this.rel_nm = rel_nm;
		this.con_rel = con_rel;
		this.con_add = con_add;
		this.con_dt = con_dt;
	}
	public String getCon_id() {
		return con_id;
	}
	public void setCon_id(String con_id) {
		this.con_id = con_id;
	}
	public String getCon_nm() {
		return con_nm;
	}
	public void setCon_nm(String con_nm) {
		this.con_nm = con_nm;
	}
	public String getCon_num() {
		return con_num;
	}
	public void setCon_num(String con_num) {
		this.con_num = con_num;
	}
	public String getRel_nm() {
		return rel_nm;
	}
	public void setRel_nm(String rel_nm) {
		this.rel_nm = rel_nm;
	}
	public String getCon_rel() {
		return con_rel;
	}
	public void setCon_rel(String con_rel) {
		this.con_rel = con_rel;
	}
	public String getCon_add() {
		return con_add;
	}
	public void setCon_add(String con_add) {
		this.con_add = con_add;
	}
	public String getCon_dt() {
		return con_dt;
	}
	public void setCon_dt(String con_dt) {
		this.con_dt = con_dt;
	}
	@Override
	public String toString() {
		return "[ID=" +con_id+ ", 이름=" + con_nm + ", 번호=" + con_num + ", 관계=" + rel_nm
				+ ", 주소=" + con_add + ", 업데이트날짜=" + con_dt + "]";
	}
	
}
