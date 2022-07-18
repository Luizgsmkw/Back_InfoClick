package com.api.projetoFinal.domain;

import javax.persistence.*;

import com.api.projetoFinal.domain.dtos.ConsumidorDTO;
import com.api.projetoFinal.domain.enums.Perfil;
import org.hibernate.validator.constraints.br.CPF;

import java.util.stream.Collectors;

@Entity
public class Consumidor extends Pessoa {

	private static final long serialVersionUID = 1L;

	@CPF
	@Column(unique = true)
	private String cpf;

	public Consumidor() {
		super();
		addPerfil(Perfil.CONSUMIDOR);
	}

	public Consumidor(Integer id, String nome, String email, String password, String celular, String cep, String estado, String cidade, String bairro, String rua, String numero, String cpf) {
		super(id, nome, email, password, celular, cep, estado, cidade, bairro, rua, numero);
		this.cpf = cpf;
		addPerfil(Perfil.CONSUMIDOR);
	}

	public Consumidor(ConsumidorDTO obj){
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.celular = obj.getCelular();
		this.cep = obj.getCep();
		this.estado = obj.getEstado();
		this.cidade = obj.getCidade();
		this.bairro = obj.getBairro();
		this.rua = obj.getRua();
		this.numero = obj.getNumero();
		this.cpf = obj.getCpf();
		this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
