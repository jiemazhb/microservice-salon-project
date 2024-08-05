package com.microservice.ownerService.repository;

import com.microservice.ownerService.Entiry.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerEntity, Long> {
}
