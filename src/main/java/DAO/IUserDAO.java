package DAO;

import java.util.List;

import Models.User;

public interface IUserDAO {

	List<User> findAll();
	
	void insert(User model);
	
	User findOne(int id);
	
	User findByUserName(String username);
	
	void update(User model);
	
	void delete(int id);
	
	void insertregister(User user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	void updatestatus(User user);
}
