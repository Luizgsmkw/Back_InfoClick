package com.api.projetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetoFinal.domain.Loja;

import java.util.Optional;

public interface LojaRepository extends JpaRepository<Loja, Integer> {

    Optional<Loja> findById(Integer id);
}
