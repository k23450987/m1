package project.mapper;

import java.util.List;

import project.domain.Job;

public interface JobMapper {

	/**
	 * 查询目前所有职位
	 * 
	 * @return
	 */
	List<Job> selectAll();

	/**
	 * 查询某部门下的岗位
	 * 
	 * @return
	 */
	List<Job> selectJobs(Integer fdept_id);

	/**
	 * 根据id号删除岗位
	 * 
	 * @param job_id
	 *            岗位的id
	 */
	void delete(Integer job_id);

	/**
	 * 新增岗位
	 * 
	 * @param job
	 *            岗位的实体
	 */
	void insert(Job job);

	/**
	 * 修改岗位信息
	 * 
	 * @param job
	 *            岗位的实体
	 */
	void update(Job job);

	/**
	 * 根据id查询某一具体岗位的详细信息
	 * 
	 * @param job_id
	 * @return
	 */
	Job selectOne(Integer job_id);

}
