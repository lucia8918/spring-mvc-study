package com.study.springmvcstudy.domain.coupon;

import com.study.springmvcstudy.application.controller.model.mapper.CouponMapper;
import com.study.springmvcstudy.application.controller.model.request.CreateCouponRequest;
import com.study.springmvcstudy.application.controller.model.response.CouponResponse;
import com.study.springmvcstudy.domain.coupon.entity.Coupon;
import com.study.springmvcstudy.domain.coupon.repository.CouponRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponDomainService {

  private final CouponRepository couponRepository;

  public CouponResponse getOne(final Long id) {
    Coupon coupon =
        couponRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    return CouponMapper.INSTANCE.toDto(coupon);
  }

  public List<CouponResponse> getList() {
    return CouponMapper.INSTANCE.toDto(couponRepository.findAll());
  }

  public CouponResponse create(final CreateCouponRequest couponDto) {
    Coupon createCoupon =
        Coupon.builder()
            .name(couponDto.getName())
            .discountPrice(couponDto.getDiscountPrice())
            .build();
    couponRepository.save(createCoupon);

    return CouponMapper.INSTANCE.toDto(createCoupon);
  }

  public void delete(final Long id){
    couponRepository.deleteById(id);
  }
}
