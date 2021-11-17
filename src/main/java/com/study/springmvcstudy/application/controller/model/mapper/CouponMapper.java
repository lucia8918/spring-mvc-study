package com.study.springmvcstudy.application.controller.model.mapper;

import com.study.springmvcstudy.application.controller.model.response.CouponResponse;
import com.study.springmvcstudy.domain.coupon.entity.Coupon;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CouponMapper extends IEntityMapper<CouponResponse, Coupon> {

  CouponMapper INSTANCE = Mappers.getMapper(CouponMapper.class);

  @Mappings({
    @Mapping(source = "id", target = "couponId"),
    @Mapping(source = "name", target = "couponName"),
    @Mapping(source = "discountPrice", target = "couponDiscountPrice")
  })
  @Override
  CouponResponse toDto(Coupon coupon);

  List<CouponResponse> toDto(List<Coupon> eList);
}
