package com.study.springmvcstudy.domain.coupon.entity;

import com.study.springmvcstudy.domain.coupon.converter.CategoryGroupConverter;
import com.study.springmvcstudy.domain.coupon.converter.CategoryTypeConverter;
import com.study.springmvcstudy.domain.coupon.converter.EnumWrapConverter;
import com.study.springmvcstudy.domain.coupon.enums.CategoryGroup;
import com.study.springmvcstudy.domain.coupon.enums.CategoryType;
import com.study.springmvcstudy.domain.coupon.enums.EnumWrap;
import java.util.Set;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coupon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private int discountPrice;

  @Convert(converter = CategoryGroupConverter.class)
  private Set<CategoryGroup> categoryGroups;

  @Convert(converter = CategoryTypeConverter.class)
  private Set<CategoryType> categoryTypes;

  @Convert(converter = EnumWrapConverter.class)
  private EnumWrap<CategoryGroup> wrapCategoryGroups;
}
