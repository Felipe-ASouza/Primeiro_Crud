package br.com.crudzinho.hyu.service;

import br.com.crudzinho.hyu.model.request.CustomerRequest;
import br.com.crudzinho.hyu.model.response.CustomerResponse;
import br.com.crudzinho.hyu.persistence.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {

    CustomerResponse create(CustomerRequest customerRequest);

    Page<CustomerResponse> getAll(Pageable pageable);

    Optional<CustomerResponse> update(Long id, CustomerRequest customerRequest);

    Optional<CustomerResponse> get(Long id);

    boolean delete(Long id);

}
