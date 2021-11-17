package com.study.springmvcstudy.application.controller.model.request;

public class CreateCouponRequest {

  private final String name;
  private final int discountPrice;

  public CreateCouponRequest(String name, int discountPrice) {
    this.name = name;
    this.discountPrice = discountPrice;
  }

  public String getName() {
    return name;
  }

  public int getDiscountPrice() {
    return discountPrice;
  }
}
