package br.com.crudzinho.hyu.service;

import br.com.crudzinho.hyu.model.request.CustomerRequest;
import br.com.crudzinho.hyu.model.response.CustomerResponse;
import br.com.crudzinho.hyu.persistence.entity.Customer;
import br.com.crudzinho.hyu.persistence.repository.CustomerRepository;
import br.com.crudzinho.hyu.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.springframework.util.Assert.notNull;


@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Mapper<CustomerRequest, Customer> requestMapper;

    @Autowired
    private Mapper<Customer, CustomerResponse> responseMapper;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        LOGGER.info("Criando um registro do cliente");
        notNull(customerRequest, "Request Inválida");
        Customer customer = this.requestMapper.map(customerRequest);
        return customerRepository.save(customer).map((Customer input) -> this.responseMapper.map(input));  //
    }

    @Override
    public Page<CustomerResponse> getAll(Pageable pageable) {
        LOGGER.info("Buscando todos os registros.");
        notNull(pageable, "Página Inválida");
        return customerRepository.findAll(pageable).map(Customer -> this.responseMapper.map(Customer));
    }

    @Override
    public Optional<CustomerResponse> update(Long id, CustomerRequest customerRequest) {
        LOGGER.info("Atualizando o registro.");
        notNull(id, "ID inválido.");

        Customer customerUpdate = this.requestMapper.map(customerRequest);

        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerUpdate.getName());
                    return this.responseMapper.map(customerRepository.save(customer));
                });

    }

    @Override
    public Optional<CustomerResponse> get(Long id) {
        LOGGER.info("Buscando regristro.");
        notNull(id, "ID Inválido.");
        return customerRepository.findById(id).map(this.responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {

        LOGGER.info("Removendo registro");
        notNull(id, "ID Inválido.");

        try {
            customerRepository.deleteById(id);
            return true;

        } catch (Exception e) {
            LOGGER.warn("Erro ao remover o registro {}", id);
            return false;
        }
    }
}
