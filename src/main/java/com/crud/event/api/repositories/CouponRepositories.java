package com.crud.event.api.repositories;

import com.crud.event.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponRepositories extends JpaRepository<Coupon, UUID> {
}
