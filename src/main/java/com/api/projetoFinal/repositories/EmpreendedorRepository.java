package com.api.projetoFinal.repositories;

import com.api.projetoFinal.domain.Empreendedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Integer> {
	
	Optional<Empreendedor> findByCnpj(String cnpj);
    Optional<Empreendedor> findByEmail(String cnpj);
}
