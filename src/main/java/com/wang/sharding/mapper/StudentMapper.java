package com.wang.sharding.mapper;

import com.wang.sharding.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2018/3/6.
 */
@Repository
public interface StudentMapper {
    Integer insert(Student s);

    List<Student> findAll();

    List<Student> findByStudentIds(List<Integer> studentIds);
}
