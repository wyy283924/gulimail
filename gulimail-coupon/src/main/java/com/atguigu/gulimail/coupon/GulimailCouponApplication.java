package com.atguigu.gulimail.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.整合整合MyBatis-plus
 *  1)导入依赖
 *  <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *     2）配置
 *      1.配置数据源
 *          1）导入数据库驱动
 *          2)在 application.yml 配置数据源
 *      2.配置MyBatis-plus
 *          1)使用@MapperScan
 *          2)告诉MyBatis-plus sql文件地址
 */
@MapperScan("com.atguigu.gulimail.coupon.dao")
@SpringBootApplication
public class GulimailCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimailCouponApplication.class, args);
    }

}
