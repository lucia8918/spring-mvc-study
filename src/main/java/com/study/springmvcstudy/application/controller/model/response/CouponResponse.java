package com.study.springmvcstudy.application.controller.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponResponse {

  private Long couponId;
  private String couponName;
  private Integer couponDiscountPrice;
}
