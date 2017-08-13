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

    public List<Person> selectByName(String p_name) {
        return personDao.selectByName(p_name);
    }

    public List<Person> selectById(Integer job_id) {
        return personDao.selectById(job_id);
    }

    public void delete(Integer person_id) {
        personDao.delete(person_id);
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

    public Person select(Integer person_id) {
        return personDao.select(person_id);
    }

}
