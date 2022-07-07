package com.api.projetoFinal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String senha;
	private Perfil perfil;

	public Admin(AdminDTO obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfil = obj.getPerfil();
	}

	public Admin(Integer idAdmin, String nome, String email, String senha) {
		super();
		this.idAdmin = idAdmin;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		setPerfil(Perfil.ADMIN);
	}

	public Admin() {
		super();
		setPerfil(Perfil.ADMIN);
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}