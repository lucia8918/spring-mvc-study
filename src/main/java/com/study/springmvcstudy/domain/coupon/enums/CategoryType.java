package com.study.springmvcstudy.domain.coupon.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {
  GRADE_A(CategoryGroup.MOTEL),
  GRADE_B(CategoryGroup.MOTEL),
  GRADE_C(CategoryGroup.MOTEL),
  ;

  private CategoryGroup categoryGroup;

  public static CategoryType lookup(String name) {
    return Arrays.stream(CategoryType.values())
        .filter(categoryType -> categoryType.name().equals(name))
        .findAny()
        .orElseThrow(() -> new RuntimeException("알수없는 타입"));
  }

  public static Set<CategoryType> defaultCategoryTypes() {
    return new HashSet<>(Arrays.asList(CategoryType.GRADE_A, CategoryType.GRADE_B));
  }
}
