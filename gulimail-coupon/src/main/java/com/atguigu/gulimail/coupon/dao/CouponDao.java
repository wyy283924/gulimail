package com.atguigu.gulimail.coupon.dao;

import com.atguigu.gulimail.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author wyy
 * @email 2080891051@qq.com
 * @date 2026-02-11 06:07:29
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
