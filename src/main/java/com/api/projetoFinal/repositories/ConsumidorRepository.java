package com.api.projetoFinal.repositories;

import com.api.projetoFinal.domain.Consumidor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumidorRepository extends JpaRepository<Consumidor, Integer> {

     Optional<Consumidor> findByCpf(String cpf);
}
