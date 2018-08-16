package org.bran.branroom.utils;

import org.bran.branroom.base.BaseTest;
import org.bran.branroom.dao.UserDao;
import org.bran.branroom.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class PasswordUtilTest extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordUtil passwordUtil;

    @Test
    public void encryptPassword() {
        List<User> userList = userDao.queryAll();
        for(User user : userList){
            passwordUtil.encryptPassword(user);
            userDao.update(user);
        }

    }

//    @Test
    public void match() {
        User user = userDao.queryByUserId("admin");
        assertEquals(true,passwordUtil.Match(user,"123456"));
    }
}