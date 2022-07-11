package com.api.projetoFinal.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.api.projetoFinal.domain.Loja;

import com.api.projetoFinal.domain.dtos.LojaDTO;
import com.api.projetoFinal.services.LojaService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/service/Lojas")
public class LojaController {
	@Autowired
	private LojaService service;
	
	@GetMapping(value = "find/{id}")
	public ResponseEntity<LojaDTO> findById(@PathVariable Integer id) {
		Loja obj = this.service.findById(id);
		return ResponseEntity.ok().body(new LojaDTO(obj));
	}
	
	 @GetMapping
	 public ResponseEntity<List<LojaDTO>>findAll() {
		 List<Loja> list = service.findAllLojas();
		 List<LojaDTO> listDTO = list.stream().map(obj -> new LojaDTO(obj)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);
	 }
	 
	 @PostMapping
	 public ResponseEntity<LojaDTO> create(@RequestBody LojaDTO objDTO) {
		 Loja newObj = service.create(objDTO);
		 URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/id").buildAndExpand(newObj.getIdLoja()).toUri();
		 return ResponseEntity.created(uri).build();
		 
	 }
	 
	  @PutMapping(value = "/{id}")
	    public ResponseEntity<LojaDTO> updateLoja(
	            @PathVariable Integer id, @RequestBody LojaDTO objDto){
	        Loja obj = service.update(id, objDto);
	        return ResponseEntity.ok().body(new LojaDTO(obj));
	    }
	  
	  @DeleteMapping(value="/{id}")
		public ResponseEntity<LojaDTO> delete(@PathVariable Integer id){
			service.delete(id);
			return ResponseEntity.noContent().build();
		}

	   
}
