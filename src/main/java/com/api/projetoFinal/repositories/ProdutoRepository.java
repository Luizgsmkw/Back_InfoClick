package com.api.projetoFinal.repositories;

import com.api.projetoFinal.domain.Produto;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
