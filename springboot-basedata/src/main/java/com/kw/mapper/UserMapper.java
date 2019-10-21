package com.kw.mapper;

import com.kw.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserMapper {
    public List<User> selectAll();

    void addUser(User user);

    User findById(int id);
}
