package com.api.projetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetoFinal.domain.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

        Optional<Admin> findByEmail(String email);


}