package com.api.projetoFinal.services;

import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.domain.Loja;
import com.api.projetoFinal.domain.dtos.LojaDTO;
import com.api.projetoFinal.repositories.EmpreendedorRepository;
import com.api.projetoFinal.repositories.LojaRepository;
import com.api.projetoFinal.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    @Autowired
    private EmpreendedorRepository empRepository;
    
    public Loja findById(Integer id) {
        Optional<Loja> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
    }
    
    public List<Loja> findAllLojas() {
        return repository.findAll();
    }

    public Loja create(LojaDTO objDto, Integer idEmpreendedor) {
        objDto.setIdLoja(null);
        Optional<Empreendedor> obj = empRepository.findById(idEmpreendedor);
        objDto.setEmpreendedor(obj.get());

        Loja newObj = new Loja(objDto);
        return repository.save(newObj);
    }

    public Loja update(Integer id, LojaDTO objDto) {
        objDto.setIdLoja(id);
        Loja oldObj = findById(id);
        oldObj = new Loja(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Loja obj = findById(id);
        repository.deleteById(id);
    }

    
}
