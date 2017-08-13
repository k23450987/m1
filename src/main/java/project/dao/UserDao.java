package project.dao;

import java.util.List;
import project.domain.User;

public interface UserDao {

    /**
     * 用户注册功能
     *
     * @param user 用户信息
     */
    int reg(User user);

    /**
     * 根据用户名，密码查找
     *
     * @param user 用户信息
     */
    List<User> login(User user);

    /**
     * 验证用户名
     *
     * @return 结果
     */
    String check(String username);
}
