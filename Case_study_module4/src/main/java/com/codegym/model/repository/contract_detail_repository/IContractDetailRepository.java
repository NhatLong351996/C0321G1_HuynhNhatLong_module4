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
    @Query(value="select cus.name_customer as nameCustomer,ser.name_service as nameService,\n" +
            " group_concat(att.name_attach_service separator ', ') as nameAttachService,sum(det.quantity) as quantity, \n" +
            " ser.cost_service as cosService,\n" +
            "sum(att.cost_attach_service) as costAttach, con.id_contract as idContract,\n" +
            " det.id as idContractDetail\n" +
            " from customer cus\n" +
            " join contract con on cus.id_customer=con.id_customer\n" +
            " join service ser on ser.id_service=con.id_service\n" +
            " left join contract_detail det on det.id_contract = con.id_contract\n" +
            " join attach_service att on att.id = det.id_attach_service\n" +
            " where att.name_attach_service like %?1%\n" +
            "group by con.id_contract\n" +
            "order by con.id_contract",nativeQuery = true,
            countQuery="select count(*)" +
                    " from customer cus\n" +
                    " join contract con on cus.id_customer=con.id_customer\n" +
                    " join service ser on ser.id_service=con.id_service\n" +
                    " left join contract_detail det on det.id_contract = con.id_contract\n" +
                    " join attach_service att on att.id = det.id_attach_service\n" +
                    " where att.name_attach_service like %?1%\n" +
                    "group by con.id_contract\n" +
                    "order by con.id_contract")
    Page<IContractDetailDto> listFindByNameAttach(Pageable pageable, String name);
    @Query(value="select cus.name_customer as nameCustomer,ser.name_service as nameService,\n" +
            " group_concat(att.name_attach_service separator ', ') as nameAttachService,sum(det.quantity) as quantity, \n" +
            " ser.cost_service as cosService,\n" +
            "sum(att.cost_attach_service) as costAttach, con.id_contract as idContract,\n" +
            " det.id as idContractDetail\n" +
            " from customer cus\n" +
            " join contract con on cus.id_customer=con.id_customer\n" +
            " join service ser on ser.id_service=con.id_service\n" +
            " left join contract_detail det on det.id_contract = con.id_contract\n" +
            " join attach_service att on att.id = det.id_attach_service\n" +
            "group by con.id_contract\n" +
            "order by con.id_contract",nativeQuery = true,
    countQuery="select count(*)\n" +
            " from customer cus\n" +
            " join contract con on cus.id_customer=con.id_customer\n" +
            " join service ser on ser.id_service=con.id_service\n" +
            " left join contract_detail det on det.id_contract = con.id_contract\n" +
            " join attach_service att on att.id = det.id_attach_service\n" +
            "group by con.id_contract\n" +
            "order by con.id_contract")
    Page<IContractDetailDto> listFindAll( Pageable pageable);
}
