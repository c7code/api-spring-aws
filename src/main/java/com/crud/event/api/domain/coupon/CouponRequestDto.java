package com.crud.event.api.domain.coupon;

public record CouponRequestDto(String code, Integer discount, Long valid) {
}
