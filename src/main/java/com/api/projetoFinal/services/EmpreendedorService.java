package com.api.projetoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.domain.dtos.EmpreendedorDTO;
import com.api.projetoFinal.repositories.EmpreendedorRepository;

@Service
public class EmpreendedorService {

	@Autowired
	private EmpreendedorRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Empreendedor findById(Integer id) {
		Optional<Empreendedor> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public Integer findIdByEmail(String email){
		return repository.findIdByEmail(email);
	}
	public List<Empreendedor> findAll() {
		return repository.findAll();
	}

	public Empreendedor create(EmpreendedorDTO objDTO) {
		objDTO.setIdEmpreendedor(null);
		objDTO.setPassword(encoder.encode(objDTO.getPassword()));
		validaPorCnpj(objDTO);
		validaEmail(objDTO);
		Empreendedor newObj = new Empreendedor(objDTO);
		return repository.save(newObj);
	}

	public Empreendedor update(Integer id, EmpreendedorDTO objDto) {
		objDto.setIdEmpreendedor(id);
		Empreendedor oldObj = findById(id);
		validaPorCnpj(objDto);
		validaEmail(objDto);
		oldObj = new Empreendedor(objDto);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Empreendedor obj = findById(id);
		repository.deleteById(id);

	}

	private void validaPorCnpj(EmpreendedorDTO objDTO) {
		Optional<Empreendedor> obj = this.repository.findByCnpj(objDTO.getCnpj());
		if (obj.isPresent() && obj.get().getIdEmpreendedor() != objDTO.getIdEmpreendedor()) {
			throw new DataIntegrityViolationException("CNPJ já cadastrado no Sistema");
		}
	}

	private void validaEmail(EmpreendedorDTO objDTO) {
		Optional<Empreendedor> obj = repository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getIdEmpreendedor() != objDTO.getIdEmpreendedor()) {
			throw new DataIntegrityViolationException("Email já cadastrado no Sistema");
		}
	}
}