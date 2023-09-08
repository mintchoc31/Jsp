package kr.co.farmstory2.service;

import java.util.List;

import kr.co.farmstory2.dao.UserDAO;
import kr.co.farmstory2.db.SQL;
import kr.co.farmstory2.dto.TermsDTO;
import kr.co.farmstory2.dto.UserDTO;

public class UserService {
	
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	private UserService() {}
	
	private UserDAO dao = UserDAO.getInstance();
	
	public void insertUser(UserDTO dto) {
		dao.insertUser(dto);
	}
	public UserDTO selectUser(String uid, String pass) {
		return dao.selectUser(uid, pass);
	}
	
	public List<UserDTO> selectUsers() {
		return dao.selectUsers();
	}
	public void updateUser(UserDTO dto) {
		dao.updateUser(dto);
	}
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
	
	// 추가
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	public int selectCountNick(String nick) {
		return dao.selectCountNick(nick);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	
	public TermsDTO selectTerms() {
		return dao.selectTerms();
	}
	public UserDTO selectUserByNameAndEmail(String name, String email) {
		// TODO Auto-generated method stub
		return dao.selectUserByNameAndEmail(name, email);
	}
	
	

	
}
