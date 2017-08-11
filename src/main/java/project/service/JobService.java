package project.service;

import java.util.List;

import project.domain.Job;

public interface JobService {

	/**
	 * 返回所有工作岗位的查询信息
	 * 
	 * @return
	 */
	List<Job> selectAllJob();

	/**
	 * 根据岗位id删除岗位
	 * 
	 * @param job_id
	 */
	void deleteJob(Integer job_id);

	/**
	 * 新增岗位
	 * 
	 * @param job
	 */
	void insertJob(Job job);

	/**
	 * 修改岗位信息
	 * 
	 * @param job
	 */
	void updateJob(Job job);

	/**
	 * 根据id查询某一具体岗位的详细信息
	 * 
	 * @param job_id
	 * @return
	 */
	Job selectOneJob(Integer job_id);
	
	/**
	 * 查询某部门下的岗位
	 * 
	 * @return
	 */
	
	List<Job> selectJobs(Integer fdept_id);
}