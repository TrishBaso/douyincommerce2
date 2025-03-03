package org.example.douyincommerce.mapper;

import org.example.douyincommerce.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT into orders(user_id,user_currency,email,created_at)values " +
            "(#{userId},#{userCurrency},#{email},#{createdAt})")
    void placeOrder(Order order);

    @Select("select * from orders where user_id=#{userId}")
    List<Order>listOrders(Long userId);

}
