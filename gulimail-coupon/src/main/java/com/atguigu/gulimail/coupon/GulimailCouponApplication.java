package com.atguigu.gulimail.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 *
 *  1.如何使用Nacos作为配置中心统一管理配置
 *  1）引入依赖
 *  <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *  2）创建一个bootsrap.properties在springboot 2.4+之后需要添加bootsrap依赖
 *  spring.application.name=coupon
 * #spring.config.import=optional:nacos: springboot2.4+不在bootstrap中需要添加
 * spring.cloud.nacos.config.server-addr=127.0.0.1:8848
 * 3）需要给配置中心默认添加一个数据集（dataId）coupon.properties默认规则：应用名。properties
 * 4)给应用名。properties添加任何配置
 * 5）动态获取配置
 * @RefreshScope 动态获取并刷新配置
 * @Value
 * 如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置
 * 2.细节
 * 1）命名空间：用作配置隔离。（一般每个微服务一个命名空间）
 *
 * 默认public。默认新增的配置都在public空间下
 *
 * 	开发、测试、开发可以用命名空间分割。properties每个空间有一份。
 *
 * 	在bootstrap.properties里配置
 *
 * spring.cloud.nacos.config.namespace=b176a68a-6800-4648-833b-be10be8bab00  	# 可以选择对应的命名空间 ,即写上对应环境的命名空间ID
 *
 * 也可以为每个微服务配置一个命名空间，微服务互相隔离
 *
 * 2）配置集：一组相关或不相关配置项的集合。
 *
 * 3）配置集ID：类似于配置文件名，即Data ID
 *
 * 4）配置分组：默认所有的配置集都属于DEFAULT_GROUP。自己可以创建分组，比如双十一，618，双十二
 *
 * spring.cloud.nacos.config.group=DEFAULT_GROUP  # 更改配置分组
 * 最终方案：每个微服务创建自己的命名空间，然后使用配置分组区分环境（dev/test/prod）
 *
 * 5）加载多配置集
 * 我们要把原来application.yml里的内容都分文件抽离出去。我们在nacos里创建好
 * 后，在coupons里指定要导入的配置即可。
 * spring.cloud.nacos.config.namespace=ed042b3b-b7f3-4734-bdcb-0c516cb357d7  # # 可以选择对应的命名空间 ，即写上对应环境的命名空间ID
 * spring.cloud.nacos.config.group=dev  # 配置文件所在的组
 *
 * spring.cloud.nacos.config.ext-config[0].data-id=datasource.yml
 * spring.cloud.nacos.config.ext-config[0].group=dev
 * spring.cloud.nacos.config.ext-config[0].refresh=true
 *
 * spring.cloud.nacos.config.ext-config[1].data-id=mybatis.yml
 * spring.cloud.nacos.config.ext-config[1].group=dev
 * spring.cloud.nacos.config.ext-config[1].refresh=true
 *
 * spring.cloud.nacos.config.ext-config[2].data-id=other.yml
 * spring.cloud.nacos.config.ext-config[2].group=dev
 * spring.cloud.nacos.config.ext-config[2].refresh=true
 */
@MapperScan("com.atguigu.gulimail.coupon.dao")
@SpringBootApplication
@EnableDiscoveryClient
public class GulimailCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimailCouponApplication.class, args);
    }

}
