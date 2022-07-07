package com.api.projetoFinal.services;

import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.domain.dtos.ConsumidorDTO;
import com.api.projetoFinal.repositories.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.api.projetoFinal.services.exceptions.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorService {

    @Autowired
    private ConsumidorRepository repository;
    public List<Consumidor> findAllConsumidor() {
        return repository.findAll();
    }

    public Consumidor findById(Integer id) {
        Optional<Consumidor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
    }

    public Consumidor create(ConsumidorDTO objDto) {
        objDto.setIdConsumidor(null);
        objDto.setPassword(objDto.getPassword());
        validaCpf(objDto);
        validaEmail(objDto);
        Consumidor newObj = new Consumidor(objDto);
        return repository.save(newObj);

    }

    public Consumidor update(Integer id, ConsumidorDTO objDto) {
        objDto.setIdConsumidor(id);
        Consumidor oldObj = findById(id);
        validaCpf(objDto);
        validaEmail(objDto);
        oldObj = new Consumidor(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Consumidor obj = findById(id);
        repository.deleteById(id);
    }

    private void validaCpf(ConsumidorDTO objDto) {

		Optional<Consumidor> obj = repository.findByCpf(objDto.getCpf());
		if (obj.isPresent() && obj.get().getIdConsumidor() != objDto.getIdConsumidor()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
	}

    private void validaEmail(ConsumidorDTO objDto){
        Optional<Consumidor> obj = repository.findByEmail(objDto.getEmail());
		if (obj.isPresent() && obj.get().getIdConsumidor() != objDto.getIdConsumidor()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
        
    }
}
