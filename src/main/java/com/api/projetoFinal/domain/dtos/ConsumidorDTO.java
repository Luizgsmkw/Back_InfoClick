package com.api.projetoFinal.domain.dtos;

import javax.validation.constraints.NotNull;

import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.domain.enums.Perfil;

public class ConsumidorDTO extends Consumidor {

	private static final long serialVersionUID = 1L;

	protected Integer idConsumidor;
	@NotNull(message = "O campo NOME não poderá ser nulo")
	protected String nome;
	@NotNull(message = "O CPF não poderá ser nulo")
	protected String cpf;
	@NotNull(message = "O E-MAIL não poderá ser nulo")
	protected String email;
	@NotNull(message = "O campo de SENHA não pode ser nulo")
	protected String password;
	protected Perfil perfil;
	protected String celular;
	protected String cep;
	protected String estado;
	protected String cidade;
	protected String bairro;
	protected String rua;
	protected String numero;

	public ConsumidorDTO() {
		super();
	}

	public ConsumidorDTO(Consumidor obj) {
		super();
		this.idConsumidor = obj.getIdConsumidor();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.perfil = obj.getPerfil();
		this.celular = obj.getCelular();
		this.cep = obj.getCep();
		this.estado = obj.getEstado();
		this.cidade = obj.getCidade();
		this.bairro = obj.getBairro();
		this.rua = obj.getRua();
		this.numero = obj.getNumero();
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getIdConsumidor() {
		return idConsumidor;
	}

	public void setIdConsumidor(Integer idConsumidor) {
		this.idConsumidor = idConsumidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}