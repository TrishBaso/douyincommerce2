package org.example.douyincommerce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.douyincommerce.pojo.User;


import java.util.Map;

public interface UserService extends IService<User> {

    Map<String, Object> getLogin(String username, String password);

    IPage<Map<String, Object>> queryall(IPage<Map<String, Object>> page);

    void insertUserRole(Long uid);
}
