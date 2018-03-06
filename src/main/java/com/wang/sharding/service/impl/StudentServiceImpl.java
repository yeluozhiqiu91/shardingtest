package com.wang.sharding.service.impl;

import com.wang.sharding.entity.Student;
import com.wang.sharding.mapper.StudentMapper;
import com.wang.sharding.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by wang on 2018/3/6.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0 ? true : false;
    }
}
