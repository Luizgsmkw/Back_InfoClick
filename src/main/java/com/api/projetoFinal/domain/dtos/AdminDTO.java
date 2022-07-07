package com.api.projetoFinal.domain.dtos;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.domain.enums.Perfil;

public class AdminDTO extends Admin {

	private static final long serialVersionUID = 1L;

	protected Integer idAdmin;
	protected String nome;
	protected String email;
	protected String senha;
	protected Perfil perfil;

	public AdminDTO() {
		super();
		setPerfil(Perfil.ADMIN);
	}

	public AdminDTO(Admin obj) {
		super();
		this.idAdmin = obj.getIdAdmin();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfil = obj.getPerfil();
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