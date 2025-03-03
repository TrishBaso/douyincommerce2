package org.example.douyincommerce.mapper;

import org.example.douyincommerce.pojo.Cart;
import org.example.douyincommerce.pojo.CartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartMapper {
    @Select("SELECT * FROM cartitem WHERE id = #{cartId}")
    Cart getCartByUserId(Long cartId);
    @Select("select * from cartitem where id=#{userId}")
    List<CartItem> getCartItemsByCartId(Long userId);

//    @Insert("INSERT into cart(cart_id,user_id,product_id,quantity)values (#{userId},#{item.productId},#{item.quantity})")
//    void addItem(@Param("userId") Long userId, @Param("item")CartItem item);

    @Insert("INSERT INTO cartitem (cart_id, product_id, quantity) VALUES (#{cartId}, #{productId}, #{quantity})")
    void addCartItem(CartItem cartItem);

//    @Delete("DELETE From cart where user_id=#{userId}")
//    void emptyCart(Long userId);

    @Delete("DELETE FROM cartitem WHERE cart_id = #{cartId}")
    void emptyCart(Long cartId);

    //创建购物车
    @Insert("INSERT INTO cart (user_id) VALUES (#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createCart(Cart cart);
}
