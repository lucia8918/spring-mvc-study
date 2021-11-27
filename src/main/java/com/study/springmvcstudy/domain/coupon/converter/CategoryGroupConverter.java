package com.study.springmvcstudy.domain.coupon.converter;

import com.study.springmvcstudy.domain.coupon.enums.CategoryGroup;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public class CategoryGroupConverter implements AttributeConverter<Set<CategoryGroup>, String> {

  @Override
  public String convertToDatabaseColumn(Set<CategoryGroup> categoryGroups) {

    if (CollectionUtils.isEmpty(categoryGroups)) {
      return "";
    }

    return categoryGroups.stream()
        .map(categoryGroup -> categoryGroup.name())
        .collect(Collectors.joining(","));
  }

  @Override
  public Set<CategoryGroup> convertToEntityAttribute(String dbData) {

    if (!StringUtils.hasText(dbData)) return Collections.emptySet();

    return Arrays.stream(dbData.split(","))
        .map(name -> CategoryGroup.lookup(name))
        .collect(Collectors.toSet());
  }
}
