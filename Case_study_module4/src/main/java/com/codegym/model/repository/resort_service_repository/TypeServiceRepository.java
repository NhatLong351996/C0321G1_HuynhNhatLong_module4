package com.codegym.model.repository.resort_service_repository;

import com.codegym.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeServiceRepository extends JpaRepository<ServiceType,Long> {
}
