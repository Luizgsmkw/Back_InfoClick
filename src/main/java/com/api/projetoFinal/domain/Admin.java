package com.api.projetoFinal.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.*;

import com.api.projetoFinal.domain.dtos.AdminDTO;
import com.api.projetoFinal.domain.enums.Perfil;

@Entity
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAdmin;
	private String nome;
	private String email;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIL_ADMIN")
	private Set<Integer> perfil =  new HashSet<>();

	public Admin(AdminDTO obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}

	public Admin(Integer idAdmin, String nome, String email, String password) {
		super();
		this.idAdmin = idAdmin;
		this.nome = nome;
		this.email = email;
		this.password = password;
		addPerfil(Perfil.ADMIN);
	}

	public Admin() {
		super();
		addPerfil(Perfil.ADMIN);
	}

	public Set<Perfil> getPerfil() {
		return perfil.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfil.add(perfil.getCodigo());
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}