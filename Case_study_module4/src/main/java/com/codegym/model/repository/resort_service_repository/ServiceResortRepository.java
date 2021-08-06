package com.codegym.model.repository.resort_service_repository;

import com.codegym.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceResortRepository extends JpaRepository<Service,Long> {
}
