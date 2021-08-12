SELECT * FROM case04.contract_detail;
select contract_detail.id,contract_detail.quantity,contract_detail.id_attach_service,contract_detail.id_contract
 from contract_detail 
right join attach_service on contract_detail.id_attach_service=contract_detail.id_attach_service
where attach_service.name_attach_service like '%Massage%';
select * from contract_detail right join attach_service 
on contract_detail.id_attach_service=contract_detail.id_attach_service
 where attach_service.name_attach_service like '%Massage%';
 
 
 select cus.name_customer as nameCustomer,ser.name_service as nameService,
 group_concat(att.name_attach_service separator ', ') as nameAttachService,sum(det.quantity) as quantity, 
 ser.cost_service as cosService,
sum(att.cost_attach_service) as costAttach, con.id_contract as idContract,
 det.id as idContractDetail
 from customer cus
 join contract con on cus.id_customer=con.id_customer
 join service ser on ser.id_service=con.id_service
 left join contract_detail det on det.id_contract = con.id_contract
 join attach_service att on att.id = det.id_attach_service
 where att.name_attach_service=''
group by con.id_contract
order by con.id_contract;

