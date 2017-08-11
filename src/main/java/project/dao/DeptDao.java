package project.dao;

import java.util.List;

import project.domain.Dept;
import project.domain.TreeJson;

public interface DeptDao {
	/**
	 * 查找所有部门全部信息
	 * 
	 * @return
	 */
	List<Dept> finDepts();

	/**
	 * 只查找部门名称部门id
	 * 
	 * @return
	 */
	List<Dept> findFaDepts();

	/**
	 * 用于添加部门
	 * 
	 * @param dept
	 */
	void insert(Dept dept);

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
	List<Dept> finDeptByName(String dept_name);

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
	 * 查找单个部门的详细信息
	 * 
	 * @param dept_id
	 * @return
	 */
	Dept selectOne(Integer dept_id);
	
	
	List<TreeJson> getOrgInfo();
	
	
	public List<Dept> selectByfdeptid(Integer fdept_id);
	
	void setNull(Integer dept_id);

}