package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import project.domain.Person;

public interface PersonDao {

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
     * @return 所有员工
     */
    List<Person> selectAll();

    /**
     * 根据姓名模糊查询
     *
     * @param name 姓名
     * @return 所有员工
     */
    List<Person> selectByName(@Param("name") String name);

    /**
     * 根据id查询岗位下员工
     *
     * @param id 岗位 ID
     * @return 所有员工
     */
    List<Person> selectById(@Param("id") Integer id);

    /**
     * 根据id查询某一员工
     *
     * @param id 员工 ID
     * @return 员工
     */
    Person select(@Param("id") Integer id);

    /**
     * 根据id删除员工
     *
     * @param id 员工 ID
     */
    void delete(@Param("id") Integer id);

    /**
     * 增加员工
     *
     * @param person 员工
     * @return 员工 ID
     */
    int insert(Person person);

    /**
     * 更新员工资料
     *
     * @param person 员工
     */
    void updateInfo(Person person);

    /**
     * 用于分配岗位
     *
     * @param person 员工
     */
    void updateJobInfo(Person person);

}
