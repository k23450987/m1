package project.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import project.dao.PersonDao;
import project.domain.Person;
import project.mapper.PersonMapper;

@Repository
public class PersonDaoImpl extends SqlSessionDaoSupport implements PersonDao {
	// mybatis3.2.2+mybatis-spring1.2.0必须自己注入sqlSessionFactory

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 查询当前所有员工信息
	 */
	public List<Person> selectAllPersons() {
		return getSqlSession().getMapper(PersonMapper.class).selectAll();
	}

	/**
	 * 根据部门id查询
	 */
	public List<Person> selectPersonById(Integer job_id) {
		return getSqlSession().getMapper(PersonMapper.class).selectPersonById(job_id);
	}

	/**
	 * 根据姓名模糊查询员工
	 */
	public List<Person> selectPersonByName(String p_name) {
		return getSqlSession().getMapper(PersonMapper.class).selectPersonByName(p_name);
	}

	/**
	 * 根据id删除员工
	 */
	public void deletePerson(Integer person_id) {
		getSqlSession().getMapper(PersonMapper.class).delete(person_id);
	}

	/**
	 * 增加员工
	 */
	public void insertPerson(Person person) {
		getSqlSession().getMapper(PersonMapper.class).insert(person);
	}

	/**
	 * 更新员工资料
	 */
	public void updatePersonInfo(Person person) {
		getSqlSession().getMapper(PersonMapper.class).updateInfo(person);
	}

	/**
	 * 用于分配岗位
	 */
	public void updatePersonJobInfo(Person person) {
		getSqlSession().getMapper(PersonMapper.class).updateJobInfo(person);
	}

	/**
	 * 根据id查询某一员工
	 */
	public Person selectOnePerson(Integer person_id) {
		return getSqlSession().getMapper(PersonMapper.class).selectOne(person_id);
	}


}
