package com.kw.service.impl;

import com.github.pagehelper.PageHelper;
import com.kw.mapper.UserMapper;
import com.kw.model.User;
import com.kw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

;


    @Override
    public List<User> getUser() {
        PageHelper.startPage(1, 20);
        List<User> list=userMapper.selectAll();
		/*ValueOperations<String, Object> rs=redisTemplate.opsForValue();
		redisTemplate.expire("key3", 20, TimeUnit.SECONDS);
		if(redisTemplate.hasKey("key3")) {
			rs.get("key3");
			List<User> list2=JSONObject.parseArray(rs.get("key3").toString(), User.class);
			return list2;
		}else {
			rs.set("key3",JSON.toJSON(list).toString());
		}*/
        return list;
    }



    @Override
    public void add() {
        User user=new User();
        user.setUsername("tom测试电话");
        user.setPassword("123456");
        userMapper.addUser(user);
    }



    @Override
    public User findById(int id) {
        User user=new User();
        user.setUsername("tom测试电话");
        user.setPassword("123456");
        userMapper.addUser(user);
        return userMapper.findById(id);
    }
}
