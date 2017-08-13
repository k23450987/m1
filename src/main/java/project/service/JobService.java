package project.service;

import java.util.List;

import project.domain.Job;

public interface JobService {

    /**
     * 返回所有工作岗位的查询信息
     */
    List<Job> selectAll();

    /**
     * 根据岗位id删除岗位
     */
    void delete(Integer id);

    /**
     * 新增岗位
     */
    void insert(Job job);

    /**
     * 修改岗位信息
     */
    void update(Job job);

    /**
     * 根据id查询某一具体岗位的详细信息
     */
    Job select(Integer id);

    /**
     * 查询某部门下的岗位
     */

    List<Job> selectJobs(Integer parentDeptId);
}