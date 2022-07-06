package com.api.projetoFinal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetoFinal.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}