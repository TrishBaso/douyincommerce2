package org.example.douyincommerce.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.douyincommerce.pojo.Commodity;
import org.example.douyincommerce.service.CommodityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Resource
    private CommodityService commodityService;

    /**
     * 查询所有商品信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/queryall", method = RequestMethod.GET)
    public Map<String, Object> queryall(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        IPage<Map<String, Object>> page = new Page<>(pageNum, pageSize);
        IPage<Map<String, Object>> result = commodityService.queryall(page);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("data", result);
        return map;
    }

    /**
     * 创建商品
     * @param commodity
     * @return
     */
    @RequestMapping(value = "/addcommodity",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Commodity commodity){
        boolean result = commodityService.save(commodity);
        Map<String,Object> map = new HashMap<>();
        if (result = true){
            map.put("code",200);
            map.put("msg","创建成功");
            map.put("data",result);
        }else {
            map.put("code",201);
            map.put("msg","创建失败");
            map.put("data","error");
        }
        return map;
    }

    /**
     * 动态查询（实现查询商品信息）
     * @param pageNum
     * @param pageSize
     * @param shop
     * @param productname
     * @return
     */
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Map<String,Object> queryCondition(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "shop",required = false) String shop,
            @RequestParam(value = "productname",required = false) String productname
    ){
        Commodity commodity = new Commodity();
        commodity.setShop(shop);
        commodity.setProductname(productname);
        IPage<Map> postIPage = commodityService.getCommodityByConditionAndPage(pageNum,pageSize,commodity);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "查询");
        map.put("data", postIPage);
        return map;
    }

    /**
     * 下面可以完成其他要求
     */

}
