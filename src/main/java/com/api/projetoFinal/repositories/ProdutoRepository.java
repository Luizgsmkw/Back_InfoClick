package com.api.projetoFinal.repositories;

import com.api.projetoFinal.domain.Produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findById(Integer id);
    @Query(value = "select u from Produto u where lower(trim(u.name)) like %?1%")
   List<Produto> buscarPorNome(String name );
}
