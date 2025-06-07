package com.crud.event.api.domain.address;


import com.crud.event.api.domain.event.Event;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Table(name = "address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Adress {

    @Id
    @GeneratedValue
    private UUID id;

    private String city;
    private String uf;

    @ManyToOne
    @JoinColumn(name = "event")
    private Event event;

}
