package project.service;

import java.util.List;
import java.util.Map;

import project.domain.User;

public interface UserService {
	/**
	 * 将用户名，密码存入一个map，提交查询
	 */
	List<User> login(@SuppressWarnings("rawtypes") Map map);

	/**
	 * 用户注册
	 */
	void reg(User user);

	/**
	 * 验证用户名
	 * 
	 * @return
	 */
	Boolean check(String username);
}