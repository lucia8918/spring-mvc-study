package com.study.springmvcstudy.domain.coupon.converter;

import com.study.springmvcstudy.domain.coupon.enums.CategoryGroup;
import com.study.springmvcstudy.domain.coupon.enums.EnumWrap;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;
import org.springframework.util.StringUtils;

public class EnumWrapConverter implements AttributeConverter<EnumWrap<CategoryGroup>, String> {

  @Override
  public String convertToDatabaseColumn(EnumWrap<CategoryGroup> attribute) {
    if (Objects.isNull(attribute)) return "";
    return attribute.getEnums().stream().map(String::valueOf).collect(Collectors.joining(","));
  }

  @Override
  public EnumWrap<CategoryGroup> convertToEntityAttribute(String dbData) {

    if (!StringUtils.hasText(dbData)) return null;

    return new EnumWrap<>(
        Arrays.stream(dbData.split(","))
            .map(item -> CategoryGroup.lookup(item))
            .collect(Collectors.toSet()));
  }
}
