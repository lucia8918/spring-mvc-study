package com.study.springmvcstudy.domain.coupon.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Set;

public class EnumWrap<T> {
  @JsonValue
  private Set<T> enums;

  public EnumWrap(Set<T> enums) {
    this.enums = enums;
  }

  public void setEnums(Set<T> enums) {
    this.enums = enums;
  }

  public Set<T> getEnums() {
    return enums;
  }
}
