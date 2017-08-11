package project.dao;

import java.util.List;

import project.domain.Person;

public interface PersonDao {

	/**
	 * 查询所有员工
	 * 
	 * @return
	 */
	List<Person> selectAllPersons();

	/**
	 * 根据id删除员工
	 * 
	 * @param person_id
	 */
	void deletePerson(Integer person_id);

	/**
	 * 增加员工
	 * 
	 * @param person
	 */
	void insertPerson(Person person);

	/**
	 * 更新员工资料
	 * 
	 * @param person
	 */
	void updatePersonInfo(Person person);

	/**
	 * 用于分配岗位
	 * 
	 * @param person
	 */
	void updatePersonJobInfo(Person person);

	/**
	 * 根据id查询某一员工
	 * 
	 * @param person_id
	 * @return
	 */
	Person selectOnePerson(Integer person_id);
	
	/**
	 * 根据姓名模糊查询员工
	 */
	List<Person> selectPersonByName(String p_name);
	
	List<Person> selectPersonById(Integer job_id);
}