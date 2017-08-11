package project.dao.impl;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;
import project.dao.JobDao;
import project.domain.Job;
import project.mapper.JobMapper;

@Repository
public class JobDaoImpl extends SqlSessionDaoSupport implements JobDao {

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	/**
	 * 查询所有工作岗位的方法
	 */
	public List<Job> selectAllJob() {
		return getSqlSession().getMapper(JobMapper.class).selectAll();
	}

	/**
	 * 查询某部门下的岗位
	 */
	public List<Job> selectJobs(Integer fdept_id) {
		return getSqlSession().getMapper(JobMapper.class).selectJobs(fdept_id);
	}

	/**
	 * 根据岗位id删除岗位
	 */
	public void deleteJob(Integer job_id) {
		getSqlSession().getMapper(JobMapper.class).delete(job_id);
	}

	/**
	 * 新增岗位
	 */
	public void insertJob(Job job) {
		getSqlSession().getMapper(JobMapper.class).insert(job);
	}

	/**
	 * 修改岗位信息
	 */
	public void updateJob(Job job) {
		getSqlSession().getMapper(JobMapper.class).update(job);
	}

	/**
	 * 根据id查询某一具体岗位的详细信息
	 */
	public Job selectOneJob(Integer job_id) {
		return getSqlSession().getMapper(JobMapper.class).selectOne(job_id);
	}
}
