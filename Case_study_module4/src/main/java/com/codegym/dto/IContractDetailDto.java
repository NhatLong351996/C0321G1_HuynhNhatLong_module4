package com.codegym.dto;

public interface IContractDetailDto {
    String getNameCustomer();
    String getNameService();
    String getNameAttachService();
    Long getIdContract();
    Long getIdContractDetail();
    Integer getQuantity();
    Integer getCosService();
    Integer getCostAttach();
}
