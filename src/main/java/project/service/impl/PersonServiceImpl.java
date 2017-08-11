package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.PersonDao;
import project.domain.Person;
import project.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Resource
	private PersonDao personDao;

	/**
	 * 查询所有员工信息
	 */
	public List<Person> selectAllPersons() {
		return personDao.selectAllPersons();
	}

	/**
	 * 根据姓名模糊查询员工
	 */
	public List<Person> selectPersonByName(String p_name) {
		return personDao.selectPersonByName(p_name);
	}

	/**
	 * 根据部门id查询员工
	 */
	public List<Person> selectPersonById(Integer job_id) {
		return personDao.selectPersonById(job_id);
	}

	/**
	 * 根据id删除员工
	 */
	public void deletePerson(Integer person_id) {
		personDao.deletePerson(person_id);
	}

	/**
	 * 增加员工操作
	 */
	public void insertPerson(Person person) {
		personDao.insertPerson(person);
	}

	/**
	 * 更新员工资料
	 */
	public void updatePersonInfo(Person person) {
		personDao.updatePersonInfo(person);
	}

	/**
	 * 更新员工岗位
	 */
	public void updatePersonJobInfo(Person person) {
		personDao.updatePersonJobInfo(person);
	}

	/**
	 * 根据id查询某一员工
	 */
	public Person selectOnePerson(Integer person_id) {
		return personDao.selectOnePerson(person_id);
	}

}
