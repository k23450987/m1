package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.domain.Job;
import project.dao.JobDao;
import project.service.JobService;

@Service
public class JobServiceImpl implements JobService {

    @Resource
    private JobDao jobDao;

    public List<Job> selectAll() {
        return jobDao.selectAll();
    }

    public void delete(Integer id) {
        jobDao.delete(id);
    }

    public void insert(Job job) {
        jobDao.insert(job);
    }

    public void update(Job job) {
        jobDao.update(job);
    }

    public Job select(Integer id) {
        return jobDao.select(id);
    }

    public List<Job> selectJobs(Integer parentDeptId) {
        return jobDao.selectJobs(parentDeptId);
    }
}
