package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.domain.Dept;
import project.domain.TreeJson;
import project.dao.DeptDao;
import project.dao.TreeJsonDao;
import project.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;
    @Resource
    private TreeJsonDao treeJsonDao;

    public List<Dept> select() {
        return deptDao.select();
    }

    public List<Dept> selectFather() {
        return deptDao.selectParent();
    }

    public List<Dept> selectByName(String name) {
        return deptDao.selectByName(name);

    }

    public void insert(Dept dept) {
        deptDao.insert(dept);
    }

    public void delete(Integer id) {
        deptDao.delete(id);
        List<Dept> list = deptDao.selectByParentDeptId(id);
        if (list.size() != 0) {
            for (Dept dept : list) {
                deptDao.setNull(dept.getId());
            }
        }
    }

    public void updateFather(Dept dept) {
        deptDao.updateParent(dept);
    }

    public void update(Dept dept) {
        deptDao.update(dept);
    }

    public Dept selectOne(Integer id) {
        return deptDao.selectOne(id);
    }

    public List<TreeJson> getOrgInfo() {
        List<TreeJson> treeList = treeJsonDao.getOrgInfo();
        treeList = TreeJson.buildtree(treeList, 0);
        treeList = TreeJson.formatTree(treeList);
        return treeList;
    }
}
