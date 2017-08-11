package project.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import project.dao.DeptDao;
import project.domain.Dept;
import project.domain.TreeJson;
import project.mapper.DeptMapper;
import project.mapper.TreeJsonMapper;

@Repository
public class DeptDaoImpl extends SqlSessionDaoSupport implements DeptDao {

	/**
	 * 获取 SqlSessionFactory
	 */
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 查找所有部门的详细信息
	 */
	public List<Dept> finDepts() {
		return getSqlSession().getMapper(DeptMapper.class).select();
	}

	/**
	 * 通过部门名称查找部门
	 */
	public List<Dept> finDeptByName(String dept_name) {
		return getSqlSession().getMapper(DeptMapper.class)
				.selectByName(dept_name);
	}

	/**
	 * 只查找部门id，名称，用于显示父部门
	 */
	public List<Dept> findFaDepts() {
		return getSqlSession().getMapper(DeptMapper.class).selectFather();
	}

	/**
	 * 用于添加部门
	 */
	public void insert(Dept dept) {
		getSqlSession().getMapper(DeptMapper.class).insert(dept);
	}

	/**
	 * 根据id删除部门
	 */
	public void delete(Integer dept_id) {
		getSqlSession().getMapper(DeptMapper.class).delete(dept_id);
	}

	/**
	 * 用于提升部门到树的顶端，一般不建议单独使用
	 */
	public void updateFather(Dept dept) {
		getSqlSession().getMapper(DeptMapper.class).updateFather(dept);
	}

	/**
	 * 修改部门信息
	 */
	public void update(Dept dept) {
		getSqlSession().getMapper(DeptMapper.class).update(dept);
	}

	/**
	 * 查找单个部门的详细信息
	 */
	public Dept selectOne(Integer dept_id) {
		return getSqlSession().getMapper(DeptMapper.class).selectOne(dept_id);
	}


	public List<TreeJson> getOrgInfo() {
		return getSqlSession().getMapper(TreeJsonMapper.class).getOrgInfo();
	}

	public List<Dept> selectByfdeptid(Integer fdept_id) {
		return getSqlSession().getMapper(DeptMapper.class).selectByfdeptid(fdept_id);
	}


	public void setNull(Integer dept_id) {

		getSqlSession().getMapper(DeptMapper.class).setNull(dept_id);
	}
}
