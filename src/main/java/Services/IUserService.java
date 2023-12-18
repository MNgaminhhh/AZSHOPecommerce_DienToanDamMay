package Services;

import java.util.List;

import Models.User;

public interface IUserService {
List<User> findAll();
	
	void insert(User model);
	
	User findOne(int id);
	
	User findByUserName(String username);
	
	void update(User model);
	
	void delete(int id);
	
	boolean register(String email, String password, String username, String code);
	
	void updatestatus(User user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	User login(String username, String password);
}
