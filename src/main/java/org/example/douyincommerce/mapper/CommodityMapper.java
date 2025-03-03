package org.example.douyincommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.douyincommerce.pojo.Commodity;

import java.util.Map;

@Mapper
public interface CommodityMapper extends BaseMapper<Commodity> {

    IPage<Map> query(IPage<Map> page,@Param("commodity") Commodity commodity);

}
