package project.dao.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import project.dao.UserDao;
import project.domain.User;
import project.mapper.UserMapper;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 用户注册
	 */
	public void regUser(User user) {
		getSqlSession().getMapper(UserMapper.class).reg(user);
	}

	/**
	 * 用户登录
	 */
	public List<User> loginUser(@SuppressWarnings("rawtypes") Map map) {
		return getSqlSession().getMapper(UserMapper.class).login(map);
	}

	/**
	 * 验证用户名
	 */
	public String check(String username) {
		return getSqlSession().getMapper(UserMapper.class).check(username);
	}
}
