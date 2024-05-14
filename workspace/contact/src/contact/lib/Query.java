package contact.lib;

public class Query {
	public String select() {
		String sql = "SELECT c.con_id				"
				+ "     , c.con_nm					"
				+ "     , c.con_num					"
				+ "     , r.rel_nm					"
				+ "     , c.con_rel 				"
				+ "     , c.con_add					"
				+ "     , c.con_dt					"
				+ "  FROM RELATION r , CONTACT c 	"
				+ " WHERE r.REL_NO = c.con_rel		"
				+ " ORDER BY C.CON_ID ASC";
		return sql;
	}
	public String find(String name) {
		String sql = "SELECT c.con_id				"
				+ "     , c.con_nm					"
				+ "     , c.con_num					"
				+ "     , r.rel_nm					"
				+ "     , c.con_rel 				"
				+ "     , c.con_add					"
				+ "     , c.con_dt					"
				+ "  FROM RELATION r , CONTACT c 	"
				+ " WHERE r.REL_NO = c.con_rel		"
				+ "   AND c.con_nm LIKE '"+name+"'	";
		return sql;
	}
	public String relation() {
		String sql = "SELECT *"
				+ "  FROM relation r";
		return sql;
	}
}
