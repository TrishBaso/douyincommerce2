package org.example.douyincommerce.pojo;

import lombok.Data;

@Data
public class AddItemRequ {
    private Long userId;
    private CartItem item; //商品及数量
}
