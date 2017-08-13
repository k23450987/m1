package project.service;

import java.util.List;

import project.domain.Dept;
import project.domain.TreeJson;

public interface DeptService {

    /**
     * 查找所有部门的详细信息
     *
     * @return 部门信息
     */
    List<Dept> select();

    /**
     * 只查找部门id，名称，用于显示父部门
     *
     * @return 部门信息
     */
    List<Dept> selectFather();

    /**
     * 用于添加部门
     *
     * @param dept 部门信息
     */
    void insert(Dept dept);

    /**
     * 根据id删除部门
     *
     * @param id 部门 ID
     */
    void delete(Integer id);

    /**
     * 用于提升部门到树的顶端，一般不建议单独使用
     *
     * @param dept 部门信息
     */
    void updateFather(Dept dept);

    /**
     * 修改部门信息
     *
     * @param dept 部门信息
     */
    void update(Dept dept);

    /**
     * 通过部门名称查找部门
     *
     * @param name 部门名称
     * @return 部门信息列表
     */
    List<Dept> selectByName(String name);

    /**
     * 查找单个部门的详细信息
     *
     * @param id 部门 ID
     * @return 部门信息
     */
    Dept selectOne(Integer id);

    /**
     * 获取树状结构
     *
     * @return 树
     */
    List<TreeJson> getOrgInfo();

}