package com.study.springmvcstudy.application.controller;

import com.study.springmvcstudy.application.controller.model.request.CreateCouponRequest;
import com.study.springmvcstudy.application.controller.model.response.CouponResponse;
import com.study.springmvcstudy.domain.coupon.CouponDomainService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {

  private final CouponDomainService couponDomainService;

  @GetMapping("/{id}")
  public ResponseEntity<CouponResponse> get(@PathVariable(value = "id") Long id) {
    return ResponseEntity.ok(couponDomainService.getOne(id));
  }

  @GetMapping("")
  public ResponseEntity<List<CouponResponse>> getList() {
    return ResponseEntity.ok(couponDomainService.getList());
  }

  @PostMapping("/")
  public ResponseEntity<CouponResponse> create(
      @RequestBody CreateCouponRequest createCouponRequest) {
    return ResponseEntity.ok(couponDomainService.create(createCouponRequest));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
    couponDomainService.delete(id);
    return ResponseEntity.ok("OK");
  }
}
