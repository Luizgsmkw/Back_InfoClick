package com.api.projetoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.repositories.AdminRepository;
import com.api.projetoFinal.services.exceptions.ObjectNotFoundException;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public List<Admin> findAllAdmin() {
		return repository.findAll();
	}

	public Admin findById(Integer id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Admin não encontrado"));
	}
}