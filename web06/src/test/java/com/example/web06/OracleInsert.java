package com.example.web06;

import java.sql.*;

public class OracleInsert {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.75.128:1521:xe", "spring", "1234");
						
			String sql = "insert into tbl_member(userid, userpw, username, email) values (?,?,?,?)" ;
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "hong");
			stmt.setString(2, "1234");
			stmt.setString(3, "홍길동");
			stmt.setString(4, "hong@azwell.co.kr");
			System.out.println(sql);
			int count = stmt.executeUpdate();
			
			System.out.println(count + "건 입력되었습니다.");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(stmt != null){
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
