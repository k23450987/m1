package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.domain.Person;
import project.dao.PersonDao;
import project.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonDao personDao;

    public List<Person> selectAll() {
        return personDao.selectAll();
    }

    public List<Person> selectByName(String name) {
        return personDao.selectByName(name);
    }

    public List<Person> selectByJobId(Integer jobId) {
        return personDao.selectById(jobId);
    }

    public void delete(Integer id) {
        personDao.delete(id);
    }

    public void insert(Person person) {
        personDao.insert(person);
    }

    public void updateInfo(Person person) {
        personDao.updateInfo(person);
    }

    public void updateJobInfo(Person person) {
        personDao.updateJobInfo(person);
    }

    public Person select(Integer id) {
        return personDao.select(id);
    }

}
