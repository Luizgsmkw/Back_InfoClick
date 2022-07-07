package com.api.projetoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.domain.dtos.EmpreendedorDTO;
import com.api.projetoFinal.repositories.EmpreendedorRepository;

@Service
public class EmpreendedorService {
	
	@Autowired
	private EmpreendedorRepository repository;
	
	public Empreendedor findById(Integer id) {
		Optional<Empreendedor> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Empreendedor> findAll() {
		return repository.findAll();
	}

	public Empreendedor create(EmpreendedorDTO objDTO) {
		objDTO.setIdEmpreendedor(null);
		Empreendedor newObj = new Empreendedor(objDTO);
		return repository.save(newObj);		
	}

	public Empreendedor update(Integer id, EmpreendedorDTO objDto) {
		objDto.setIdEmpreendedor(id);
        Empreendedor oldObj = findById(id);
        oldObj = new Empreendedor(objDto);
        return repository.save(oldObj);
    }

	public void delete(Integer id) {
		Empreendedor obj = findById(id);
		repository.deleteById(id);
		
	}
	

	
}
