package project.dao;

import java.util.List;
import java.util.Map;

import project.domain.User;

public interface UserDao {

	/**
	 * 用户注册
	 * 
	 * @param user
	 */
	void regUser(User user);

	/**
	 * 用户登录
	 * 
	 * @param map
	 * @return
	 */
	List<User> loginUser(@SuppressWarnings("rawtypes") Map map);

	/**
	 * 验证用户名
	 * 
	 */
	String check(String username);

}