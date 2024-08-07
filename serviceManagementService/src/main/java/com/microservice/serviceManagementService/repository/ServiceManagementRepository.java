package com.microservice.serviceManagementService.repository;

import com.microservice.serviceManagementService.entity.SalonServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceManagementRepository extends JpaRepository<SalonServiceEntity, Long> {
    Optional<SalonServiceEntity> findByServiceName(String serviceName);
}
