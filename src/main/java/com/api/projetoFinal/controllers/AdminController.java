package com.api.projetoFinal.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.domain.dtos.AdminDTO;
import com.api.projetoFinal.services.AdminService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/service/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	@GetMapping
	public ResponseEntity<List<AdminDTO>> findAllAdmin() {
		List<Admin> list = service.findAllAdmin();
		List<AdminDTO> listDto = list.stream().map(adm -> new AdminDTO(adm)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> findById(@PathVariable Integer id) {
		Admin obj = service.findById(id);
		return ResponseEntity.ok().body(new AdminDTO(obj));
	}

}