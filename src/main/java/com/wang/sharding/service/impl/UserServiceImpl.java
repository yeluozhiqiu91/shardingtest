package com.wang.sharding.service.impl;

import com.wang.sharding.entity.Student;
import com.wang.sharding.entity.User;
import com.wang.sharding.mapper.StudentMapper;
import com.wang.sharding.mapper.UserMapper;
import com.wang.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wang on 2018/3/6.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserMapper userMapper;

    @Autowired
    public StudentMapper studentMapper;

    public boolean insert(User u) {
        return userMapper.insert(u) > 0 ? true :false;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> findByUserIds(List<Integer> ids) {
        List<User> users=userMapper.findByUserIds(ids);
        if (users==null||users.size()==0){
            return null;
        }
        return users;
    }

    public List<User> findByUserIdBetween(int startId, int endId) {
        List<User> users=userMapper.findByUserIdBetween(startId,endId);
        if (users==null||users.size()==0){
            return null;
        }
        return users;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public void transactionTestSucess() {
        User u = new User();
        u.setUserId(13);
        u.setAge(25);
        u.setName("war3 1.27");
        userMapper.insert(u);

        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        studentMapper.insert(student);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void transactionTestFailure() throws IllegalAccessException {
        User u = new User();
        u.setUserId(13);
        u.setAge(25);
        u.setName("war3 1.27 good");
        userMapper.insert(u);

        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe1");
        studentMapper.insert(student);
        throw new IllegalAccessException();
    }
}
