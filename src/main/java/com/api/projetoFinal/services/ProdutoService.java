package com.api.projetoFinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.api.projetoFinal.domain.Produto;
import com.api.projetoFinal.domain.dtos.ProdutoDTO;
import com.api.projetoFinal.repositories.ProdutoRepository;
import com.api.projetoFinal.services.exceptions.ObjectNotFoundException;

public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;
    public List<Produto> findAllConsumidor() {
        return repository.findAll();
    }

    public Produto findById(Integer id) {
        Optional<Produto> obj = this.repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
    }

    public Produto create(ProdutoDTO objDto) {
        objDto.setId(null);
        Produto newObj = new Produto(objDto);
        return repository.save(newObj);

    }

    public Produto update(Integer id, ProdutoDTO objDto) {
        objDto.setId(id);
        Produto oldObj = findById(id);
        oldObj = new Produto(objDto);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        Produto obj = findById(id);
        repository.deleteById(id);
    }
}
