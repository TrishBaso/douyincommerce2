package org.example.douyincommerce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.douyincommerce.pojo.User;
import org.example.douyincommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 创建用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody User user){
        boolean result = userService.save(user);
        Long uid = user.getId();
        userService.insertUserRole(uid);
        Map<String,Object> map = new HashMap<>();
        if (result = true){
            map.put("code",200);
            map.put("msg","创建成功");
            map.put("data",result);
        }else {
            map.put("code",201);
            map.put("msg","创建失败");
            map.put("data",result);
        }
        return map;
    }

    /**
     * 查询所有用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/queryall",method = RequestMethod.GET)
    public Map<String,Object> queryall(
        @RequestParam(value = "pageNum" ,defaultValue = "1") int pageNum,
        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize
    ){
        IPage<Map<String,Object>> page = new Page<>(pageNum,pageSize);
        IPage<Map<String,Object>> result =userService.queryall(page);
        Map<String,Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("data", result);
        return map;
    }

    /**
     * 下面可以完成其他要求
     */
}
