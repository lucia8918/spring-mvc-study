package com.study.springmvcstudy.application.controller.model.response;

import com.study.springmvcstudy.domain.coupon.enums.CategoryGroup;
import com.study.springmvcstudy.domain.coupon.enums.CategoryType;
import com.study.springmvcstudy.domain.coupon.enums.EnumWrap;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CouponResponse {

  private Long couponId;
  private String couponName;
  private Integer couponDiscountPrice;
  private Set<CategoryGroup> categoryGroups;
  private Set<CategoryType> categoryTypes;
  private EnumWrap<CategoryGroup> wrapCategoryGroups;
}
