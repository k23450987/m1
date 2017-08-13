package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import project.domain.Dept;

public interface DeptDao {

    /**
     * 查找所有部门的详细信息
     *
     * @return 所有部门
     */
    List<Dept> select();

    /**
     * 只查找部门id，名称
     *
     * @return 部门
     */
    List<Dept> selectParent();

    /**
     * 用于添加部门
     *
     * @param dept 部门
     */
    int insert(Dept dept);

    /**
     * 用于提升部门到树的顶端，一般不建议单独使用
     *
     * @param dept 部门
     */
    void updateParent(Dept dept);

    /**
     * 修改部门信息
     *
     * @param dept 部门
     */
    void update(Dept dept);

    /**
     * 根据id删除部门
     *
     * @param id ID
     */
    void delete(@Param("id") Integer id);

    /**
     * 通过部门名称查找部门
     *
     * @param name 名称
     * @return 部门
     */
    List<Dept> selectByName(@Param("name") String name);

    /**
     * 查找单个部门的详细信息
     *
     * @param id ID
     * @return 单个部门
     */
    Dept selectOne(@Param("id") Integer id);

    /**
     * 父部门id置空
     *
     * @param id 父部门 ID
     */
    void setNull(@Param("id") Integer id);

    /**
     * 通过父部门id查询
     *
     * @param id 父部门 ID
     * @return 部门
     */
    List<Dept> selectByParentDeptId(@Param("id") Integer id);

}
