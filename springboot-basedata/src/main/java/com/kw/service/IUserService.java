package com.kw.service;

import com.kw.model.User;

import java.util.List;

public interface IUserService {
        List<User> getUser();

        void add(User user);

        User findById(int id);

        void update(User user);

        void delete(int id);
}
