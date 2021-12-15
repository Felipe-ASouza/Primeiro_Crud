package br.com.crudzinho.hyu.service.mapper;

public interface Mapper<A, B> {

    B map(A input);
}
