package com.crud.event.api.repositories;

import com.crud.event.api.domain.address.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepositories extends JpaRepository<Adress, UUID> {
}
