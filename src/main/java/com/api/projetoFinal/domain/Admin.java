package com.api.projetoFinal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.api.projetoFinal.domain.dtos.AdminDTO;

@Entity
public class Admin implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Integer idAdmin;
	private String nome;
	private String email;
	private String senha;

	public Admin(AdminDTO obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getnome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public Admin() {
		super();
	}

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getnome() {
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