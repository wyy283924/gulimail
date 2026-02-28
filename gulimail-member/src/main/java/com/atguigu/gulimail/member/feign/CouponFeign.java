package com.atguigu.gulimail.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 这是一个远程的feign调用
 */
@FeignClient("coupon")
public interface CouponFeign {
    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupon();
}
