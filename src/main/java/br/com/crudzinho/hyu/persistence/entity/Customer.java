package br.com.crudzinho.hyu.persistence.entity;

import javax.persistence.*;
import java.util.function.Function;

@Entity
@Table(name = "db_customer")  //
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //gera o ID automaticamente
    @Column(name = "id")
    private long id;

    @Column(name = "name")    //nullable define que o campo nao pode ser null
    private String name;

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "email", nullable = false)
    private String email;

    public <R> R map(Function<Customer, R> func){
        return func.apply(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
