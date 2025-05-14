package com.crud.event.api.repositories;

import com.crud.event.api.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRepositories extends JpaRepository <Event, UUID>{
}
