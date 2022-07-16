package com.api.projetoFinal.domain;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.*;

import org.hibernate.validator.constraints.br.CPF;

import com.api.projetoFinal.domain.dtos.ConsumidorDTO;
import com.api.projetoFinal.domain.enums.Perfil;

@Entity
public class Consumidor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsumidor;
	private String nome;
	@CPF
	@Column(unique = true)
	private String cpf;
	@Column(unique = true)
	private String email;
	private String password;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIL_CONSUMIDOR")
	private Set<Integer> perfil =  new HashSet<>();
	private String celular;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	
	private String profilePic;

	public Consumidor(ConsumidorDTO obj) {
		super();
		this.idConsumidor = obj.getIdConsumidor();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.celular = obj.getCelular();
		this.cep = obj.getCep();
		this.estado = obj.getEstado();
		this.cidade = obj.getCidade();
		this.bairro = obj.getBairro();
		this.rua = obj.getRua();
		this.numero = obj.getNumero();
		this.profilePic = obj.getProfilePic();
		this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}

	public Consumidor(Integer idConsumidor, String nome,@CPF String cpf, String email, String password, String celular,
			String cep, String estado, String cidade, String bairro, String rua, String numero, String profilePic){
		this.idConsumidor = idConsumidor;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.password = password;
		this.celular = celular;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.profilePic = profilePic;
	}

	public Consumidor() {
		super();
	}


	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Set<Perfil> getPerfil() {
		return perfil.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfil.add(perfil.getCodigo());
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Consumidor that = (Consumidor) o;
		return idConsumidor.equals(that.idConsumidor) && cpf.equals(that.cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConsumidor, cpf);
	}
}
