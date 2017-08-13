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
     */
    List<Person> selectByName(String p_name);

    /**
     * 根据id删除员工
     */
    void delete(Integer person_id);

    /**
     * 增加员工操作
     */
    void insert(Person person);

    /**
     * 更新员工资料
     */
    void updateInfo(Person person);

    /**
     * 更新员工岗位
     */
    void updateJobInfo(Person person);

    /**
     * 根据id查询某一员工
     */
    Person select(Integer person_id);


    List<Person> selectById(Integer job_id);

}