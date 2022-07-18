package com.api.projetoFinal.controllers;

import com.api.projetoFinal.domain.Pessoa;
import com.api.projetoFinal.domain.dtos.PessoaDTO;
import com.api.projetoFinal.services.PessoaService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "service/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;


    @GetMapping(value = "/{email}")
    public ResponseEntity<Pessoa> findByEmail(@PathVariable String email) throws ObjectNotFoundException {
        Pessoa obj = service.findByEmail(email);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }
}
