package com.api.projetoFinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public List<Admin> findAllAdmin() {
		return repository.findAll();
	}
}