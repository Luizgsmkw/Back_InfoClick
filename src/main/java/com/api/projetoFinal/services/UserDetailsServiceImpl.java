package com.api.projetoFinal.services;
import java.util.Optional;

import com.api.projetoFinal.Security.UserSS;
import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.repositories.AdminRepository;
import com.api.projetoFinal.repositories.ConsumidorRepository;
import com.api.projetoFinal.repositories.EmpreendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private EmpreendedorRepository empreendedorRepository;

    @Autowired
    private ConsumidorRepository consumidorRepository;

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Empreendedor> user = empreendedorRepository.findByEmail(email);
        Optional<Consumidor> user2 = consumidorRepository.findByEmail(email);
        Optional<Admin> user3 = adminRepository.findByEmail(email);
        if(user.isPresent()) {
            return new UserSS(
                    user.get().getIdEmpreendedor(),
                    user.get().getEmail(),
                    user.get().getPassword(),
                    user.get().getPerfil());
        }else if(user2.isPresent()) {
            return new UserSS(
                    user2.get().getIdConsumidor(),
                    user2.get().getEmail(),
                    user2.get().getPassword(),
                    user2.get().getPerfil());
        }else if(user3.isPresent()) {
            return new UserSS(
                    user3.get().getIdAdmin(),
                    user3.get().getEmail(),
                    user3.get().getPassword(),
                    user3.get().getPerfil());
        }
        throw new UsernameNotFoundException(email);
    }

}
