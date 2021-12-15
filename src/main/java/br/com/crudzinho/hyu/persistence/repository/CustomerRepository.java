package br.com.crudzinho.hyu.persistence.repository;

import br.com.crudzinho.hyu.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
//Classe que faz a comunicação com o banco de dados