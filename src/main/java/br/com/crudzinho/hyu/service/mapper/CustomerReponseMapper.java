package br.com.crudzinho.hyu.service.mapper;

import br.com.crudzinho.hyu.model.response.CustomerResponse;
import br.com.crudzinho.hyu.persistence.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerReponseMapper implements Mapper<Customer, CustomerResponse>{
    @Override
    public CustomerResponse map(Customer input) {
        if(input == null){
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(input.getId());
        customerResponse.setName(input.getName());
        customerResponse.setDocument(input.getDocument());
        customerResponse.setEmail(input.getEmail());

        return customerResponse;

    }
}
