package com.sds.icto.guestbook.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.vo.guestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;


	public void insert(guestbookVo vo) {
		
			sqlMapClientTemplate.insert("guestbook.insert", vo);

	}
	
	@SuppressWarnings("unchecked")
	public void delete(int no, String pwd) {
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("n", no);
		map.put("p", pwd);
		
		sqlMapClientTemplate.delete("guestbook.delete", map);
	}
	

	@SuppressWarnings("unchecked")
	public List<guestbookVo> fetchList() {
		List<guestbookVo> list = sqlMapClientTemplate.queryForList("guestbook.list");
		return list;
	}

//	public void delete(String pwd) {
//		try {
//			sqlMapClient.insert("guestbook.delete", pwd);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}

	// public void delete(int no, String pwd){
	// try{
	// // 1. Connection 생성
	// Connection conn = getConnection();
	// // 2. Statement(SQL) 준비
	// String sql = "delete from guestbook where no = ? and password=?";
	// PreparedStatement pstmt = conn.prepareStatement(sql);
	// // 3.binding
	// pstmt.setInt(1, no);
	// pstmt.setString(2, pwd);
	//
	// // 4. query 실행
	// pstmt.executeUpdate();
	// // 5. 자원정리
	// if (pstmt != null) {
	// pstmt.close();
	// }
	// if (conn != null) {
	// conn.close();
	// }
	// }catch(Exception e){
	// e.printStackTrace();
	// }
	// }

}
