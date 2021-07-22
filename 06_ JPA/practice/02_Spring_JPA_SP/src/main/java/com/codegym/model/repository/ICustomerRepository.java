package com.codegym.model.repository;

import com.codegym.model.bean.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
