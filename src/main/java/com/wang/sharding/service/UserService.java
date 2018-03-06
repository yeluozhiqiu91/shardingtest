package com.wang.sharding.service;

import com.wang.sharding.entity.User;

import java.util.List;

/**
 * Created by wang on 2018/3/6.
 */
public interface UserService {
    public boolean insert(User u);

    public List<User> findAll();

    public List<User> findByUserIds(List<Integer> ids);

    public List<User> findByUserIdBetween(int startId,int endId);

    public void transactionTestSucess();

    public void transactionTestFailure() throws IllegalAccessException;
}
