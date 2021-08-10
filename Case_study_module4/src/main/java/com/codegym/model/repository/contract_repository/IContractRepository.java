package com.codegym.model.repository.contract_repository;

import com.codegym.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IContractRepository extends JpaRepository <Contract,Long> {
    @Query(value = "select * from contract where year(date_end)=:year ",nativeQuery=true)
    Page<Contract> findByYear(@Param("year") String year, Pageable pageable);


}
