package com.api.projetoFinal.domain.dtos;

import com.api.projetoFinal.domain.Admin;

public class AdminDTO extends Admin {

	private static final long serialVersionUID = 1L;

	protected Integer idAdmin;
	protected String nome;
	protected String email;
	protected String senha;

	public AdminDTO() {
		super();
	}

	public AdminDTO(Admin obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getnome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}