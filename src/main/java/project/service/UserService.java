package project.service;

import java.util.List;
import project.domain.User;

public interface UserService {
	/**
	 * 将用户名，密码存入一个map，提交查询
	 *
	 * @param user 用户信息
	 */
	List<User> login(User user);

	/**
	 * 用户注册
     *
     * @param user 用户信息
	 */
	void reg(User user);

	/**
	 * 验证用户名
	 *
     * @param username 用户名
	 * @return 是否存在
	 */
	Boolean check(String username);
}