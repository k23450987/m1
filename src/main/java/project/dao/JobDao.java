package project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import project.domain.Job;

public interface JobDao {

    /**
     * 查询目前所有职位
     *
     * @return 职位
     */
    List<Job> selectAll();

    /**
     * 查询某部门下的岗位
     *
     * @return 职位
     */
    List<Job> selectJobs(Integer parentDeptId);

    /**
     * 根据id号删除岗位
     *
     * @param id 岗位的id
     */
    void delete(@Param("id") Integer id);

    /**
     * 新增岗位
     *
     * @param job 岗位的实体
     */
    int insert(Job job);

    /**
     * 修改岗位信息
     *
     * @param job 岗位的实体
     */
    void update(Job job);

    /**
     * 根据id查询某一具体岗位的详细信息
     *
     * @param id ID
     * @return 职位
     */
    Job select(@Param("id") Integer id);

}
