package org.example.douyincommerce.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.douyincommerce.pojo.Commodity;

import java.util.Map;

public interface CommodityService extends IService<Commodity> {

    IPage<Map<String, Object>> queryall(IPage<Map<String, Object>> page);

    IPage<Map> getCommodityByConditionAndPage(int pageNum, int pageSize, Commodity commodity);
}
