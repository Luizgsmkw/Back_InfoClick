package com.api.projetoFinal.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.domain.Loja;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LojaDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idLoja;	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();
	private String corDeFundo;
	@NotNull(message = "O campo NOME DA LOJA não poderá ser nulo")
	private String nomeLoja;
	private String descricaoLoja;
	@NotNull(message = "Um empreendedor precisa estar vinculado a Loja")
	private Empreendedor empreendedor;

    public LojaDTO() {
		super();
	}

	public LojaDTO(Loja obj) {
		super();
		this.idLoja = obj.getIdLoja();
		this.corDeFundo = obj.getCorDeFundo();
		this.nomeLoja = obj.getNomeLoja();
		this.descricaoLoja = obj.getDescricaoLoja();
		this.empreendedor = obj.getEmpreendedor();
	}

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
	}

	public Empreendedor getEmpreendedor() {
		return empreendedor;
	}

	public void setEmpreendedor(Empreendedor empreendedor) {
		this.empreendedor = empreendedor;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCorDeFundo() {
		return corDeFundo;
	}

	public void setCorDeFundo(String corDeFundo) {
		this.corDeFundo = corDeFundo;
	}

	public String getNomeLoja() {
		return nomeLoja;
	}

	public void setNomeLoja(String nomeLoja) {
		this.nomeLoja = nomeLoja;
	}

	public String getDescricaoLoja() {
		return descricaoLoja;
	}

	public void setDescricaoLoja(String descricaoLoja) {
		this.descricaoLoja = descricaoLoja;
	}
}
