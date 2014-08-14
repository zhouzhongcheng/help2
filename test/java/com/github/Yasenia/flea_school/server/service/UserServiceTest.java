package com.github.Yasenia.flea_school.server.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.Yasenia.flea_school.server.SpringBaseTest;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.IUserService;

public class UserServiceTest extends SpringBaseTest{
    @Autowired
    private IUserService userService;
    
    @Before
    public void setUp() {
    }    
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = DBException.class)
    public void testSave(){
        // 插入用户1， 成功插入则id自动生成
        User user1 = new User();
        user1.setUserName("test");
        user1.setPassword("test");
        user1.setRealName("test");
        user1.setSex(0);
        user1.setCoin(0);
        user1.setPoint(0);
        user1.setRegisterDate(new Date());
        userService.save(user1);
        assertNotNull(user1.getId());
        
        // 插入同名用户2，抛出异常
        User user2 = new User();
        user2.setUserName("test");
        user2.setPassword("test");
        user2.setRealName("test2");
        user2.setSex(0);
        user2.setCoin(0);
        user2.setPoint(0);
        user2.setRegisterDate(new Date());
        userService.save(user2);
    }
    
    @Test
    public void testFindById() {
        
    }
}
