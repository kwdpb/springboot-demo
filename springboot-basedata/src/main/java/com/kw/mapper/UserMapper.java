package com.kw.mapper;

import com.kw.model.User;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.Null;
import java.util.List;


public interface UserMapper {
    public List<User> selectAll();

    void addUser(User user);

    User findById(int id);

    Integer update(User user);

    void delete(int id);
}
