package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.JobDao;
import project.domain.Job;
import project.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Resource
	private JobDao jobDao;

	/**
	 * 返回所有工作岗位的查询信息
	 */
	public List<Job> selectAllJob() {
		return jobDao.selectAllJob();
	}

	/**
	 * 根据岗位id删除岗位
	 */
	public void deleteJob(Integer job_id) {
		jobDao.deleteJob(job_id);
	}

	/**
	 * 添加岗位
	 */
	public void insertJob(Job job) {
		jobDao.insertJob(job);
	}

	/**
	 * 修改岗位信息
	 */
	public void updateJob(Job job) {
		jobDao.updateJob(job);
	}

	/**
	 * 根据id查询某一具体岗位的详细信息
	 */
	public Job selectOneJob(Integer job_id) {
		return jobDao.selectOneJob(job_id);
	}

	/**
	 * 查询某部门下的岗位
	 */
	public List<Job> selectJobs(Integer fdept_id) {
		return jobDao.selectJobs(fdept_id);
	}
}
