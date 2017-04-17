package com.example.web06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleJdbcTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url="jdbc:oracle:thin:@192.168.75.128:1521:xe";
		String sql = null;
		
		try {
			//1. DBMS Driver 로딩	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 객체 획득
			conn = DriverManager.getConnection(url, "spring", "1234");
			
			//3. Statement 객체 생성
			stmt = conn.createStatement();
			
			//4. SQL 실행
			sql = "select userid, userpw, username, email, regdate, updatedate from tbl_member";
			rs = stmt.executeQuery(sql.toString());
			
			//5. ResultSet 을 이용한 결과 처리
			while(rs.next()){
				System.out.println("userid, userpw, username, email, regdate, updatedate");
				System.out.print(rs.getString(1)+", ");
				System.out.print(rs.getString(2)+", ");
				System.out.print(rs.getString(3)+", ");
				System.out.print(rs.getString(4)+", ");
				System.out.print(rs.getDate(5)+", ");
				System.out.println(rs.getDate(6));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			if(rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	
	}

}
