package project.mapper;

import java.util.List;

import project.domain.Person;

public interface PersonMapper {

	/*
	 * List<Person> select(Map map);
	 * 
	 * void insert(Person person);
	 * 
	 * void update(Person person);
	 * 
	 * void delete(Integer id);
	 * 
	 * List<Person> login(Map map);
	 */

	/**
	 * 查询当前所有员工
	 * 
	 * @return
	 */
	List<Person> selectAll();

	/**
	 * 根据姓名模糊查询
	 * 
	 * @return
	 */
	List<Person> selectPersonByName(String p_name);

	/**
	 * 根据id查询岗位下员工
	 * 
	 * @return
	 */
	List<Person> selectPersonById(Integer job_id);

	/**
	 * 根据id查询某一员工
	 * 
	 * @param id
	 * @return
	 */
	Person selectOne(Integer person_id);

	/**
	 * 根据id删除员工
	 * 
	 * @param person_id
	 */
	void delete(Integer person_id);

	/**
	 * 增加员工
	 * 
	 * @param person
	 */
	void insert(Person person);

	/**
	 * 更新员工资料
	 * 
	 * @param person
	 */
	void updateInfo(Person person);

	/**
	 * 用于分配岗位
	 * 
	 * @param person
	 */
	void updateJobInfo(Person person);

}
