package Services.Impl;

import java.util.List;

import DAO.IUserDAO;
import DAO.Impl.UserDAO;
import Models.User;
import Services.IUserService;

public class UserSerive implements IUserService {
	
	IUserDAO userDao = new UserDAO();

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void insert(User model) {
		userDao.insert(model);
		
	}

	@Override
	public User findOne(int id) {
		return userDao.findOne(id);
	}

	@Override
	public void update(User model) {
		User olduser = userDao.findOne(model.getUserID());
		olduser.setUserID(model.getUserID());
		olduser.setUserName(model.getUserName());
		olduser.setPassword(model.getPassword());
		olduser.setEmail(model.getEmail());
		olduser.setRole(model.getRole());
		olduser.setStatus(model.getStatus());
		
		userDao.update(olduser);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public boolean register(String email, String password, String username, String code) {
		if(userDao.checkExistEmail(email)) {
			return false;
		}
		if(userDao.checkExistUsername(username)) {
			return false;
		}
		userDao.insertregister(new User(username, password, email, code, 2, 1));
		return true;
	}

	@Override
	public void updatestatus(User user) {
		userDao.updatestatus(user);
		
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public User login(String username, String password) {
		User user = userDao.findByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User findByUserName(String username) {
		return userDao.findByUserName(username);
	}

}
