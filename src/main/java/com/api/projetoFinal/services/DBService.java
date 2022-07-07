package com.api.projetoFinal.services;

import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.repositories.ConsumidorRepository;

import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.repositories.EmpreendedorRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private ConsumidorRepository consumidorRepository;
    
    @Autowired
    private EmpreendedorRepository empreendedorRepository;

    public void instanciaDB() {
        Consumidor c1 = new Consumidor(null,"Gabriel", "193.019.997-06", "gabriel@gmail.com","1234","21992934144","2271140","Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");
        Consumidor c2 = new Consumidor(null,"Mingau", "382.670.620-09", "mingau@gmail.com","1234","10881823033","2271140","Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");

        Empreendedor e1 = new Empreendedor(null,"Loja 1", "73.900.564/0001-54", "loja1@gmail.com", "123456", "21988887777", "22720400", "Rio de Janeiro", "Rio de Janeiro", "Taquara", "maraville", "1155");
        Empreendedor e2 = new Empreendedor(null,"Loja 2", "86.005.261/0001-10", "loja2@gmail.com", "123456", "21945451234", "22720400", "Rio de Janeiro", "Rio de Janeiro", "Taquara", "Mio", "895");
        
        consumidorRepository.saveAll(Arrays.asList(c1,c2));
        empreendedorRepository.saveAll(Arrays.asList(e1,e2));
        
    }
}
