package com.study.springmvcstudy.domain.coupon.enums;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum CategoryGroup {
  MOTEL,
  HOTEL,
  RESORT,
  ;

  public static CategoryGroup lookup(String name) {
    return Arrays.stream(CategoryGroup.values())
        .filter(categoryGroup -> categoryGroup.name().equals(name))
        .findAny()
        .orElseThrow(() -> new RuntimeException("알수없는 타입"));
  }

  public static Set<CategoryGroup> defaultCategoryGroups() {
    return new HashSet<>(Arrays.asList(CategoryGroup.MOTEL, CategoryGroup.HOTEL));
  }
}
