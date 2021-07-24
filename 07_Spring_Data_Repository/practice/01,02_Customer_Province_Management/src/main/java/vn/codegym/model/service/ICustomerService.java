package vn.codegym.model.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.bean.Customer;
import vn.codegym.model.bean.Province;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer t);

    void remove(Long id);
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
