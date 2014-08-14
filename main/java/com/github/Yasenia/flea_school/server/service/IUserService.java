package com.github.Yasenia.flea_school.server.service;

import com.github.Yasenia.flea_school.server.entity.User;

public interface IUserService {
    public void save(User user);

    public void update(User user);
    
    public User findById(Integer id);

    public User findByUserName(String userName);

}
