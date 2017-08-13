package project.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.DeptDao;
import project.dao.TreeJsonDao;
import project.domain.Dept;
import project.domain.TreeJson;
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
        treeList = buildtree(treeList, 0);
        treeList = formatTree(treeList);
        return treeList;
    }

    /**
     * 往树里添加节点
     * @param nodes 节点集合
     * @param id ID
     * @return 树
     */
    private List<TreeJson> buildtree(List<TreeJson> nodes, int id) {
        List<TreeJson> treeJsons = new ArrayList<>();
        for (TreeJson treeJson : nodes) {
            TreeJson node = new TreeJson();
            node.setId(treeJson.getId());
            node.setText(treeJson.getText());
            if (id == treeJson.getPid()) {
                node.setChildren(buildtree(nodes, node.getId()));
                treeJsons.add(node);
            }
        }
        return treeJsons;
    }

    /**
     * 将根节点的 state 设置为 "closed"
     * @param treeList 树
     * @return 树
     */
    private List<TreeJson> formatTree(List<TreeJson> treeList) {
        for (TreeJson treeJson : treeList) {
            if (treeJson.getChildren().size() != 0) {
                formatTree(treeJson.getChildren());
                treeJson.setState("closed");
            }
        }
        return treeList;
    }
}
