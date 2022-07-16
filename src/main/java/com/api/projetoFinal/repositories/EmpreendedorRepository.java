package com.api.projetoFinal.repositories;

import com.api.projetoFinal.domain.Empreendedor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpreendedorRepository extends JpaRepository<Empreendedor, Integer> {
	
	Optional<Empreendedor> findByCnpj(String cnpj);
    Optional<Empreendedor> findByEmail(String cnpj);
    Optional<Empreendedor> findById(Integer id);

    @Query(value = "select e.idEmpreendedor from Empreendedor e where e.email = ?1")
    Integer findIdByEmail(String email);
}
