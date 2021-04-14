package com.victor.springprojectbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.victor.springprojectbackend.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
