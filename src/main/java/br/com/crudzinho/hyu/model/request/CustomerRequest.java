package br.com.crudzinho.hyu.model.request;


import javax.validation.constraints.NotBlank;

public class CustomerRequest {


    @NotBlank                       //Para que a Request nao venha em branco
    private String name;
    @NotBlank
    private String document;
    @NotBlank
    private String email;

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
