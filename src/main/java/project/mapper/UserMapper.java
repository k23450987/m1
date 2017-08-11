package project.mapper;

import java.util.List;
import java.util.Map;

import project.domain.User;

public interface UserMapper {
	/**
	 * 用户注册功能
	 * 
	 * @param user
	 */
	void reg(User user);

	/**
	 * 根据用户名，密码查找
	 * 
	 * @param map
	 * @return
	 */
	List<User> login(@SuppressWarnings("rawtypes") Map map);

	/**
	 * 验证用户名
	 * 
	 * @return
	 */
	String check(String username);
}
