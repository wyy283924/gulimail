package com.atguigu.gulimail.order.dao;

import com.atguigu.gulimail.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author wyy
 * @email 2080891051@qq.com
 * @date 2026-02-11 21:57:18
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
