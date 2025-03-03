package org.example.douyincommerce.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.douyincommerce.mapper.UserMapper;
import org.example.douyincommerce.service.UserService;
import org.example.douyincommerce.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Map<String, Object> getLogin(String username, String password) {
        Map<String, Object> loginInfo = userMapper.getLogin(username,password);
        return loginInfo;
    }

    @Override
    public IPage<Map<String, Object>> queryall(IPage<Map<String, Object>> page) {
        return userMapper.queryall(page);
    }

    @Override
    public void insertUserRole(Long uid) {
        userMapper.insertUserRole(uid);
    }
}
