package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.User2DTO;
import dto.User3DTO;

public class User3DAO {

	private final String HOST = "jdbc:mysql://3.34.178.254/UserDB";
	private final String USER = "userdb";
	private final String PASS = "Mint0531*";
	
	public void insertUser3(User3DTO dto) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement("INSERT INTO `User3` VALUES (?,?,?,?)");
			psmt.setString(1, dto.getUid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public User3DTO selectUser3(String uid) {
		
		User3DTO dto = new Use3DTO();
		try {
			Class.forName("come.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement("SELECT * FROM `User3` WHERE `uid`=?");
			psmt.setString(1, uid);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getString(4));
			}
			rs.close();
			psmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<User3DTO> selectUser3s() { 
		
		List<User3DTO> users = new ArrayList<>();
		
		try {
			Class.forName("come.mysql.cj.jdbc.Drvier");
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `User3`");
			
			while(rs.next()) {
				User2DTO dto = new User3DTO();
				dto.setUid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getString(4));
				users.add(dto);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	public void updateUser3(User3DTO dto) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement("UPDATE `User3` SET `name`=?, `hp`=?, `age`=? WHERE `uid`=?");
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUid());
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser3(String uid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			PreparedStatement psmt = conn.prepareStatement("DELETE FROM `User3` WHERE `uid`=? ");
			psmt.setString(1, uid);
			psmt.executeUpdate();
			psmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
