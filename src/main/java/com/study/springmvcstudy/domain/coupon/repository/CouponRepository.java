package com.study.springmvcstudy.domain.coupon.repository;

import com.study.springmvcstudy.domain.coupon.entity.Coupon;
import com.study.springmvcstudy.domain.coupon.enums.CategoryGroup;
import com.study.springmvcstudy.domain.coupon.enums.EnumWrap;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

  @Modifying
  @Query("UPDATE Coupon c SET c.categoryGroups = :categoryGroups WHERE c.id = :id")
  void updateCategoryGroups(
      @Param("id") Long id, @Param("categoryGroups") Set<CategoryGroup> categoryGroups);

  @Modifying
  @Query("UPDATE Coupon c SET c.wrapCategoryGroups = :wrapCategoryGroups WHERE c.id = :id")
  void updateWrapCategoryGroups(
      @Param("id") Long id,
      @Param("wrapCategoryGroups") EnumWrap<CategoryGroup> wrapCategoryGroups);
}
