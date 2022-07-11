package com.api.projetoFinal.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.api.projetoFinal.domain.Empreendedor;

import com.api.projetoFinal.domain.dtos.EmpreendedorDTO;
import com.api.projetoFinal.services.EmpreendedorService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "service/empreendedores")
public class EmpreendedorController {
	@Autowired
	private EmpreendedorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empreendedor> findById(@PathVariable Integer id) {
		Empreendedor obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	 @GetMapping
	 public ResponseEntity<List<EmpreendedorDTO>>findAll() {
		 List<Empreendedor> list = service.findAll();
		 List<EmpreendedorDTO> listDTO = list.stream().map(obj -> new EmpreendedorDTO(obj)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);
	 }
	 
	 @PostMapping
	 public ResponseEntity<EmpreendedorDTO> create(@RequestBody EmpreendedorDTO objDTO) {
		 Empreendedor newObj = service.create(objDTO);
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/id").buildAndExpand(newObj.getIdEmpreendedor()).toUri();
		 return ResponseEntity.created(uri).build();
		 
	 }
	 
	  @PutMapping(value = "/{id}")
	    public ResponseEntity<EmpreendedorDTO> updateEmpreendedor(
	            @PathVariable Integer id, @RequestBody EmpreendedorDTO objDto){
	        Empreendedor obj = service.update(id, objDto);
	        return ResponseEntity.ok().body(new EmpreendedorDTO(obj));
	    }
	  
	  @DeleteMapping(value="/{id}")
		public ResponseEntity<EmpreendedorDTO> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}

	   
}
