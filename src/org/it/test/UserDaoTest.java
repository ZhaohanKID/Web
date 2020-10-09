package org.it.test;

import org.it.dao.UserDao;
import org.it.domain.User;
import org.junit.Test;

/**
 * @Author: Z.HAN
 * @Date: 2020/10/6 17:58
 */
public class UserDaoTest {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.userLogin(loginUser);

        System.out.println(user);
    }
}
