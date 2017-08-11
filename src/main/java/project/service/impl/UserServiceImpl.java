package project.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.domain.User;
import project.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	/**
	 * 将用户名，密码存入一个map，提交查询
	 */
	public List<User> login(@SuppressWarnings("rawtypes") Map map) {
		return userDao.loginUser(map);
	}

	/**
	 * 用户注册
	 */
	public void reg(User user) {
		userDao.regUser(user);
	}

	/**
	 * 验证用户名
	 */
	public Boolean check(String username) {
		if (userDao.check(username) != null) {
			return false;
		}
		return true;
	}
}
