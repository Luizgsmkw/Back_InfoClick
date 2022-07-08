package com.api.projetoFinal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.api.projetoFinal.domain.dtos.LojaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Loja implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLoja;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();
    private String corDeFundo;
    private String nomeLoja;
    private String descricaoLoja;
	@JsonIgnore
    @OneToOne
    @JoinColumn(name = "empreendedor_id")
    private Empreendedor empreendedor;


	@OneToMany(mappedBy = "loja")
	private List<Produto> produtos = new ArrayList<>();
	public Loja() {
		super();
	}

	public Loja(LojaDTO obj) {
		super();
		this.idLoja = obj.getIdLoja();
		this.corDeFundo = obj.getCorDeFundo();
		this.nomeLoja = obj.getNomeLoja();
		this.descricaoLoja = obj.getDescricaoLoja();
		this.produtos = obj.getProdutos();
	}
	public Loja(Integer idLoja, String corDeFundo, String nomeLoja, String descricaoLoja, Empreendedor empreendedor) {
		
		super();
		this.idLoja = idLoja;
		this.corDeFundo = corDeFundo;
		this.nomeLoja = nomeLoja;
		this.descricaoLoja = descricaoLoja;
		this.empreendedor = empreendedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idLoja);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		return Objects.equals(idLoja, other.idLoja);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Integer getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Integer idLoja) {
		this.idLoja = idLoja;
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
	
	public Empreendedor getEmpreendedor() {
		return empreendedor;
	}



	public void setEmpreendedor(Empreendedor empreendedor) {
		this.empreendedor = empreendedor;
	}

		    
}
