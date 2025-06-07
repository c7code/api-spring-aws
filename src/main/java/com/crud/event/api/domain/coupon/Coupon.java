package com.crud.event.api.domain.coupon;


import com.crud.event.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "coupon")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    private String code;
    private Integer discount;
    private Date Valid;


    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;


}
