package test;

import java.sql.* ;

import common.JDBCUtil; 

public class DB_testTbl_Insert_Test {
	public static void main(String[] args) {
		
		String sql = null ; 
		Statement stmt = null; 
		PreparedStatement  pstmt = null ; 
		Connection conn = null;
		ResultSet rs = null ; 
		
		conn = JDBCUtil.getConnection(); 
		
		sql = "insert into testTbl(id, name, email) "; 
		sql += "values ( nvl (((select Max(id) from testTbl ) + 1),1) , " ; 
		sql += " ? , ? )"; 
		
		
		// 자바에서는 pstmt 에서는 예외 처리가 필요함. 
		try {
			//pstmt 활성화 
			pstmt = conn.prepareStatement(sql); 
			
			//pstmt 의 ? 에 변수 값 할당. 
			for ( int i = 0 ; i < 1000 ; i++) {
				pstmt.setString(1, "홍길동 - " + i);
				pstmt.setString(2, "aaa@aaa.com - " + i);
				
				pstmt.executeUpdate(); 
				
			}
		
			System.out.println("DB에 1000개의 레코드가 잘 저장되었습니다. ");
			
		}catch (Exception e) {
			// try{} 오류가 있을때만 작동 
			System.out.println("저장중 오류가 발생되었습니다. ");
			e.printStackTrace();
			
		} 
		
		JDBCUtil.close(pstmt, conn);
		

	}
}
