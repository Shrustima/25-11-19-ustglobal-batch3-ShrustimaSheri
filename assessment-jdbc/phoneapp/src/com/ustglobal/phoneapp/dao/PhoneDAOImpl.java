package com.ustglobal.phoneapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.ustglobal.phoneapp.dto.PhoneDB;

public class PhoneDAOImpl implements PhoneDAO{

	private int number;
	private String groups;
	public List<PhoneDB> getAllPhoneDb() {
	String url = "jdbc:mysql://localhost:3306/contactFiles?user=root&password=root";
	String sql = "select * from contact";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		ArrayList<PhoneDB> result = new ArrayList<>();
		
		while(rs.next()) {
			PhoneDB db = new PhoneDB();
	
		
			String name = rs.getString("name");
			db.setName(name);
			int number = rs.getInt("number");
			db.setNumber(number);
			String groups = rs.getString("groups");
			db.setGroups(groups);
			
			result.add(db);
		}
		return result;
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
		if(conn!=null) {
			conn.close();
		}
		if(stmt!=null) {
			stmt.close();
		}
		if(rs!=null) {
			rs.close();
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return null;
}

	public PhoneDB searchPhonedb(String name) {
		
		String url = "jdbc:mysql://localhost:3306/contactFiles?user=root&password=root";
		String sql = "select * from contact where name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				PhoneDB db = new PhoneDB();
				db.setName(rs.getString("name"));
				db.setNumber(rs.getInt("number"));
				db.setGroups(rs.getString("groups"));
				return db;
			}else {
				return null;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}if(pstmt!=null) {
					pstmt.close();
				}if(rs!=null) {
					rs.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	
		
		public PhoneDB  deletePhoneData(String name) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				//step1
//				Driver driver = new Driver();
//				DriverManager.registerDriver(driver);
//				or we can do like this
				
				Class.forName("com.mysql.jdbc.Driver");
				
				//step2
				String url = "jdbc:mysql://localhost:3306/contactFiles?user=root&password=root";
				conn = DriverManager.getConnection(url);
				
				String sql = "delete from contact where name=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
			
				
				int count = pstmt.executeUpdate();
				
				System.out.println(count + " Rows deleted");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
					if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			return null;

	


				
	}
		public PhoneDB updatePhoneData(String name) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				//step1 load the driver
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				
				//step2   get connection
				String url = "jdbc:mysql://localhost:3306/contactFiles?user=root&password=root";
				conn = DriverManager.getConnection(url);
				
				//step3   Issue SQL query
				String sql = "update  contact set  number=?, groups = ? where name=?" ;
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, number);
				pstmt.setString(2, groups);
			
				int count = pstmt.executeUpdate();
				
				
				
				//step4  Read the result
				System.out.println(count + " Row(s) updated");
						
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//step5  close all JDBC objects
				try {
					if(conn!=null) {
						conn.close();
					}if(pstmt!=null) {
						pstmt.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			//return 0;
			return null;
			
		}
}



	

