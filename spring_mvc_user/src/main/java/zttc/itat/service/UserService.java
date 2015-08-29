package zttc.itat.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.dao.IUserDao;
import zttc.itat.model.Pager;
import zttc.itat.model.User;
import zttc.itat.model.UserException;

@Service("userService")
public class UserService implements IUserService {

	private IUserDao userDao;
	
	
	
	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		User u = userDao.loadByUsername(user.getUsername());
		if(u!=null) throw new UserException("要添加的用户已经存在");
		userDao.add(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User load(int id) {
		return userDao.load(id);
	}

	public List<User> list() {
		return userDao.list();
	}

	public Pager<User> find() {
		return userDao.find();
	}

	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u==null) throw new UserException("登录用户不存在");
		if(!u.getPassword().equals(password)) throw new UserException("用户密码不正确");
		return u;
	}

}
