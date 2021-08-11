package com.codegym.model.repository.contract_detail_repository;


import com.codegym.dto.IContractDetailDto;
import com.codegym.model.entity.ContractDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Long> {
    List<ContractDetail> findByContract_IdContract(Long id);
    Page<ContractDetail> findAllByAttachService_NameAttachService(String name,Pageable pageable);
    @Query(value="select cus.name_customer as nameCustomer,ser.name_service as nameService," +
            "att.name_attach_service as nameAttachService, con.id_contract as idContract," +
            " det.id as idContractDetail" +
            " from customer cus" +
            " join contract con on cus.id_customer=con.id_customer" +
            " join service ser on ser.id_service=con.id_service" +
            " left join contract_detail det on det.id_contract = con.id_contract" +
            " join attach_service att on att.id = det.id_attach_service" +
            " where att.name_attach_service like %?1%",nativeQuery = true,
            countQuery="select count(*)" +
                    " from customer cus" +
                    " join contract con on cus.id_customer=con.id_customer" +
                    " join service ser on ser.id_service=con.id_service" +
                    " left join contract_detail det on det.id_contract = con.id_contract" +
                    " join attach_service att on att.id = det.id_attach_service" +
                    " where att.name_attach_service like %?1%")
    Page<IContractDetailDto> listFindByNameAttach(Pageable pageable, String name);
    @Query(value="select cus.name_customer as nameCustomer,ser.name_service as nameService," +
            "att.name_attach_service as nameAttachService, con.id_contract as idContract," +
            " det.id as idContractDetail" +
            " from customer cus" +
            " join contract con on cus.id_customer=con.id_customer" +
            " join service ser on ser.id_service=con.id_service" +
            " left join contract_detail det on det.id_contract = con.id_contract" +
            " join attach_service att on att.id = det.id_attach_service",nativeQuery = true,
    countQuery="select count(*)\n" +
            " from customer cus\n" +
            " join contract con on cus.id_customer=con.id_customer\n" +
            " join service ser on ser.id_service=con.id_service\n" +
            " left join contract_detail det on det.id_contract = con.id_contract\n" +
            " join attach_service att on att.id = det.id_attach_service")
    Page<IContractDetailDto> listFindAll( Pageable pageable);
}
