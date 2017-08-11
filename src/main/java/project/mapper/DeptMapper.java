package project.mapper;

import java.util.List;

import project.domain.Dept;

public interface DeptMapper {

	/**
	 * 查找所有部门的详细信息
	 * 
	 * @return
	 */
	List<Dept> select();

	/**
	 * 只查找部门id，名称
	 * 
	 * @return
	 */
	List<Dept> selectFather();

	/**
	 * 用于添加部门
	 * 
	 * @param dept
	 */
	void insert(Dept dept);

	/**
	 * 用于提升部门到树的顶端，一般不建议单独使用
	 * 
	 * @param dept
	 */
	void updateFather(Dept dept);

	/**
	 * 修改部门信息
	 * 
	 * @param dept
	 */
	void update(Dept dept);

	/**
	 * 根据id删除部门
	 * 
	 * @param dept_id
	 */
	void delete(Integer dept_id);

	/**
	 * 通过部门名称查找部门
	 * 
	 * @param dept_name
	 * @return
	 */
	List<Dept> selectByName(String dept_name);

	/**
	 * 查找单个部门的详细信息
	 * 
	 * @param dept_id
	 * @return
	 */
	Dept selectOne(Integer dept_id);
	/**
	 * 父部门id置空
	 * @param dept_id
	 */
	void setNull(Integer dept_id);
	/**
	 * 通过父部门id查询
	 * @param fdept_id
	 * @return
	 */
	List<Dept> selectByfdeptid(Integer fdept_id);

}
