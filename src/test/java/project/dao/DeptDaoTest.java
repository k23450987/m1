package project.dao;

import java.util.Objects;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.domain.Dept;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class DeptDaoTest {

    @Resource
    private DeptDao deptDao;

    @Test
    public void updateTest(){
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("usa");
        deptDao.update(dept);
    }

    @Test
    public void selectTest(){
        Dept dept = deptDao.selectOne(2);
        if (Objects.isNull(dept.getParentId())) {
            System.out.println("null");
        }
    }
}
