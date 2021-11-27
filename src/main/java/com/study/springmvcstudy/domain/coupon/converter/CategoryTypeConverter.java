package com.study.springmvcstudy.domain.coupon.converter;

import com.study.springmvcstudy.domain.coupon.enums.CategoryType;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class CategoryTypeConverter implements AttributeConverter<Set<CategoryType>, String> {

  @Override
  public String convertToDatabaseColumn(Set<CategoryType> categoryTypes) {
    if (CollectionUtils.isEmpty(categoryTypes)) {
      return "";
    }
    return categoryTypes.stream()
        .map(categoryType -> categoryType.name())
        .collect(Collectors.joining(","));
  }

  @Override
  public Set<CategoryType> convertToEntityAttribute(String dbData) {

    if (!StringUtils.hasText(dbData)) return Collections.emptySet();

    return Arrays.stream(dbData.split(","))
        .map(name -> CategoryType.lookup(name))
        .collect(Collectors.toSet());
  }
}
