package org.example.douyincommerce;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("org.example.douyincommerce.mapper")
@SpringBootApplication
public class DouyincommerceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DouyincommerceApplication.class, args);
        System.out.println("(✿◠‿◠)  ---项目启动成功！！！--- ");
    }
}
