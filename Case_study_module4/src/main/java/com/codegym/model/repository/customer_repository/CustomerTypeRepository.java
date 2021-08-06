package com.codegym.model.repository.customer_repository;

import com.codegym.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
