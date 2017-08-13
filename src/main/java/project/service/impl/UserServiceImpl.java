package project.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import project.dao.UserDao;
import project.domain.User;
import project.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public List<User> login(User user) {
        return userDao.login(user);
    }

    public void reg(User user) {
        userDao.reg(user);
    }

    public Boolean check(String username) {
        return userDao.check(username) == null;
    }
}
