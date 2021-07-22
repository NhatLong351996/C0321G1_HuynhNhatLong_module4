package com.codegym.model.service;

import com.codegym.model.bean.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
