package com.crud.event.api.repositories;

import com.crud.event.api.domain.coupon.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface CouponRepositories extends JpaRepository<Coupon, UUID> {
    List<Coupon> findByEventIdAndValidAfter(UUID eventId, Date currentDate);
}
