package org.it.dao;

import org.it.domain.User;
import org.it.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中User表的类
 * @Author: Z.HAN
 * @Date: 2020/10/6 17:31
 */
public class UserDao {
    // 声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDs());
    /**
     *  登录的方法
     * @param loginUser：用户名和密码
     * @return：用户的所有信息
     */
    public User userLogin(User loginUser) {
        try {
            String sql = "select * from `user` where username = ? and password = ?";

            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }


    }
}
