package com.api.projetoFinal.controllers;

import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.domain.dtos.ConsumidorDTO;
import com.api.projetoFinal.services.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/service/consumidores")
public class ConsumidorController {

    @Autowired
    private ConsumidorService service;

    @GetMapping(value = "find/{id}")
    public ResponseEntity<Consumidor> findById(@PathVariable Integer id){
        Consumidor obj = service.findById(id);
        return ResponseEntity.ok().body(new ConsumidorDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<Consumidor>> findAllConsumidor(){
        List<Consumidor> list = service.findAllConsumidor();
        List<Consumidor> listDto = list.stream()
                .map(tec -> new ConsumidorDTO(tec)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<ConsumidorDTO> createConsumidor(@Valid @RequestBody ConsumidorDTO objDto){
        Consumidor newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(newObj.getIdConsumidor()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<ConsumidorDTO> updateConsumidor(
            @PathVariable Integer id, @RequestBody ConsumidorDTO objDto){
        Consumidor obj = service.update(id, objDto);
        return ResponseEntity.ok().body(new ConsumidorDTO(obj));
    }

    @DeleteMapping(value="delete/{id}")
    public ResponseEntity<ConsumidorDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
