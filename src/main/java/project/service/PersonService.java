package project.service;

import java.util.List;

import project.domain.Person;

public interface PersonService {

    /**
     * 查询所有员工信息
     */
    List<Person> selectAll();

    /**
     * 根据姓名模糊查询员工
     *
     * @param name 姓名
     */
    List<Person> selectByName(String name);

    /**
     * 根据id删除员工
     *
     * @param id ID
     */
    void delete(Integer id);

    /**
     * 增加员工操作
     *
     * @param person 员工对象
     */
    void insert(Person person);

    /**
     * 更新员工资料
     *
     * @param person 员工对象
     */
    void updateInfo(Person person);

    /**
     * 更新员工岗位
     *
     * @param person 员工对象
     */
    void updateJobInfo(Person person);

    /**
     * 根据id查询某一员工
     *
     * @param id ID
     */
    Person select(Integer id);

    /**
     * 查询某一岗位下的所有员工
     *
     * @param jobId 岗位 ID
     * @return 员工集合
     */
    List<Person> selectByJobId(Integer jobId);

}