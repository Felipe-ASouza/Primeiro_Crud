package br.com.crudzinho.hyu.service.mapper;

import br.com.crudzinho.hyu.model.request.CustomerRequest;
import br.com.crudzinho.hyu.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestMapper implements Mapper<CustomerRequest, Customer>{
    @Override
    public Customer map(CustomerRequest input) {
        if(input == null){
            return null;
        }
        Customer customer = new Customer();
        customer.setName(input.getName());
        customer.setDocument(input.getDocument());
        customer.setEmail(input.getEmail());

        return customer;
    }
}
