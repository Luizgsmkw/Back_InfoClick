package com.api.projetoFinal.services;

import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.repositories.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ConsumidorRepository consumidorRepository;

    public void instanciaDB() {
        Consumidor c1 = new Consumidor(null,"Gabriel", "193.019.997-06", "gabriel@gmail.com","1234","21992934144","2271140","Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");
        Consumidor c2 = new Consumidor(null,"Mingau", "382.670.620-09", "mingau@gmail.com","1234","10881823033","2271140","Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");

        consumidorRepository.saveAll(Arrays.asList(c1,c2));
    }
}
