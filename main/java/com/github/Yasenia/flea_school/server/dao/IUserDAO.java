package com.github.Yasenia.flea_school.server.dao;

import java.util.List;

import com.github.Yasenia.flea_school.server.entity.User;

public interface IUserDAO {

    /**
     * 保存
     * */
    public void save(User user);

    /**
     * 删除
     * */
    public void delete(User user);

    /**
     * 更新
     * */
    public User update(User user);

    /**
     * 按Id查找用户
     * */
    public User findById(Integer id);

    /**
     * 按属性值查找用户，支持分页
     * */
    public List<User> findByProperty(String propertyName, Object propertyValue,
            int... rowStartIdxAndCount);

    /**
     * 查找全部用户，支持分页
     * */
    public List<User> findAll(int... rowStartIdxAndCount);

}
