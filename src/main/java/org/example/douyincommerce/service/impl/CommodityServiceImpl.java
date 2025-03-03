package org.example.douyincommerce.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.douyincommerce.mapper.CommodityMapper;
import org.example.douyincommerce.pojo.Commodity;
import org.example.douyincommerce.service.CommodityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements CommodityService {

    @Resource
    CommodityMapper commodityMapper;

    @Override
    public IPage<Map<String, Object>> queryall(IPage<Map<String, Object>> page) {
        // 使用selectMapsPage方法进行分页查询
        return commodityMapper.selectMapsPage(page, null);
    }

    @Override
    public IPage<Map> getCommodityByConditionAndPage(int pageNum, int pageSize, Commodity commodity) {
        IPage<Map> page = new Page<>(pageNum,pageSize);
        return commodityMapper.query(page,commodity);
    }
}
