package com.kw.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.kw.mapper.UserMapper;
import com.kw.model.User;
import com.kw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Override
    public List<User> getUser() {
        /*PageHelper.startPage(1, 20);*/
        List<User> list=userMapper.selectAll();
/*        ValueOperations<String, String> rs = stringRedisTemplate.opsForValue();
        stringRedisTemplate.expire("key3", 20, TimeUnit.SECONDS);
		if(stringRedisTemplate.hasKey("key3")) {
			rs.get("key3");
            List<User> list2= JSONObject.parseArray(rs.get("key3").toString(), User.class);
			return list2;
		}else {
			rs.set("key3", JSON.toJSON(list).toString());
		}*/
        return list;
    }



    @Override
    public void add(User user) {
        Date date=new Date();
        user.setOnline("0");
        user.setCreateTime(date);
        userMapper.addUser(user);
    }



    @Override
    public User findById(int id) {
        return userMapper.findById(id);
    }

    @Override
    public void update(User user) {
        User model=userMapper.findById(user.getUserId());
        model.setUsername(user.getUsername());
        model.setPassword(user.getPassword());
        model.setEmail(user.getEmail());
        model.setTel(user.getTel());
        Integer i=userMapper.update(model);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }


}
