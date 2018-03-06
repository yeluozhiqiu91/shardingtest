package com.wang.sharding.mapper;

import com.wang.sharding.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wang on 2018/3/6.
 */
@Repository
public interface UserMapper {
    Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);

    List<User> findByUserIdBetween(@Param("startId") int startId, @Param("endId") int endId);
}
