package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.DeptDao;
import project.domain.Dept;
import project.domain.TreeJson;
import project.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptDao deptDao;

	/**
	 * 查找所有部门的详细信息
	 */
	public List<Dept> finDepts() {
		return deptDao.finDepts();
	}

	/**
	 * 只查找部门名称部门id
	 */
	public List<Dept> findFaDepts() {
		return deptDao.findFaDepts();
	}

	/**
	 * 通过部门名称查找部门
	 */
	public List<Dept> finDeptByName(String dept_name) {
		return deptDao.finDeptByName(dept_name);

	}

	/**
	 * 用于添加部门
	 */
	public void insert(Dept dept) {
		deptDao.insert(dept);
	}

	/**
	 * 通过id删除部门
	 */
	public void delete(Integer dept_id) {
		deptDao.delete(dept_id);
		List<Dept> list = deptDao.selectByfdeptid(dept_id);
		if (list.size() != 0) {
			for (Dept dept : list) {
				deptDao.setNull(dept.getDept_id());
			}
		}
	}

	/**
	 * 用于提升部门到树的顶端，一般不建议单独使用
	 */
	public void updateFather(Dept dept) {
		deptDao.updateFather(dept);
	}

	/**
	 * 更新部门信息
	 */
	public void update(Dept dept) {
		deptDao.update(dept);
	}

	/**
	 * 查询某一个部门的信息
	 */
	public Dept selectOne(Integer dept_id) {
		return deptDao.selectOne(dept_id);
	}

	/**
	 * 获取部门树
	 */
	public List<TreeJson> getOrgInfo() {
		List<TreeJson> treeList = deptDao.getOrgInfo();
		treeList = TreeJson.buildtree(treeList, 0);
		treeList = TreeJson.formatTree(treeList);
		return treeList;
	}
}
