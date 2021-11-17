package com.study.springmvcstudy.domain.coupon.repository;

import com.study.springmvcstudy.domain.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {}
