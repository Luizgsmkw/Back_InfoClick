package com.api.projetoFinal.domain.dtos;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.domain.enums.Perfil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminDTO extends Admin {

	private static final long serialVersionUID = 1L;

	protected Integer idAdmin;
	protected String nome;
	protected String email;
	protected String password;
	protected Set<Integer> perfil = new HashSet<>();

	public AdminDTO() {
		super();
	}

	public AdminDTO(Admin obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}

	public Set<Perfil> getPerfil() {
		return perfil.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfil(Set<Integer> perfil) {
		this.perfil = perfil;
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