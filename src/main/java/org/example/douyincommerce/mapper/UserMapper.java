package org.example.douyincommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.douyincommerce.pojo.User;

import java.util.Map;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    @MapKey("id") // 可选，仅在需要将 List 转换为 Map 时使用
    Map<String, Object> getLogin(@Param("username") String username,@Param("password") String password);

    @MapKey("id") // 可选，仅在需要将 List 转换为 Map 时使用
    IPage<Map<String, Object>> queryall(IPage<Map<String, Object>> page);

    void insertUserRole(Long uid);
}
