package com.github.Yasenia.flea_school.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.Yasenia.flea_school.server.dao.IUserDAO;
import com.github.Yasenia.flea_school.server.entity.User;
import com.github.Yasenia.flea_school.server.exception.DBException;
import com.github.Yasenia.flea_school.server.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(User user) {
        List<User> resultList = userDAO.findByProperty("userName",
                user.getUserName());
        if (resultList != null && resultList.size() >= 1) {
            throw new DBException("用户名已经存在。");
        } else {
            user.setRegisterDate(new Date());
            user.setCoin(0);
            user.setPoint(0);
            userDAO.save(user);
        }
    }
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User findByUserName(String userName) {
        User user = null;
        List<User> resultList = userDAO.findByProperty("userName", userName);
        if (resultList != null && resultList.size() >= 1) {
            user = resultList.get(0);
        }
        return user;
    }

}
