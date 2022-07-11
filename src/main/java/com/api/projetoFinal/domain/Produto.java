package com.api.projetoFinal.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.api.projetoFinal.domain.dtos.ProdutoDTO;
import com.api.projetoFinal.domain.enums.Categoria;
import com.api.projetoFinal.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "produtoValor")
	private Double produtoValor;

	@Column(name = "produtoDescricao")
	private String produtoDescricao;

	@Column(name = "categoria_id")
	private Categoria categoria;

	@Column(name = "produtoEstoque")
	private Integer produtoEstoque;

	@Column(name = "produtoStatus")
	private Status status;

	@Column(name = "produtoImagem")
	private String produtoImagem;

	@Column(name = "produtoDesconto")
	private Double produtoDesconto;

	@Column(name = "dataCriacao")
	@CreationTimestamp
	private Date dataCriacao;

	@Column(name = "ultimaAtualizacao")
	@UpdateTimestamp
	private Date ultimaAtualizacao;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "loja_id")
	private Loja loja;

	public Produto() {
		super();
	}

	public Produto(ProdutoDTO obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.produtoValor = obj.getProdutoValor();
		this.produtoDescricao = obj.getProdutoDescricao();
		this.categoria = obj.getCategoria();
		this.produtoEstoque = obj.getProdutoEstoque();
		this.status = obj.getStatus();
		this.produtoImagem = obj.getProdutoImagem();
		this.produtoDesconto = obj.getProdutoDesconto();
		this.loja = obj.getLoja();

	}

	public Produto(Integer id, String name, Double produtoValor, String produtoDescricao, Categoria categoria,
			Integer produtoEstoque, Status status, String produtoImagem, Double produtoDesconto, Date dataCriacao,
			Date ultimaAtualizacao, Loja idLoja) {
		super();
		this.id = id;
		this.name = name;
		this.produtoValor = produtoValor;
		this.produtoDescricao = produtoDescricao;
		this.categoria = categoria;
		this.produtoEstoque = produtoEstoque;
		this.status = status;
		this.produtoImagem = produtoImagem;
		this.produtoDesconto = produtoDesconto;
		this.dataCriacao = dataCriacao;
		this.ultimaAtualizacao = ultimaAtualizacao;
		this.loja = idLoja;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getProdutoValor() {
		return produtoValor;
	}

	public void setProdutoValor(Double produtoValor) {
		this.produtoValor = produtoValor;
	}

	public String getProdutoDescricao() {
		return produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(Integer produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getProdutoImagem() {
		return produtoImagem;
	}

	public void setProdutoImagem(String produtoImagem) {
		this.produtoImagem = produtoImagem;
	}

	public Double getProdutoDesconto() {
		return produtoDesconto;
	}

	public void setProdutoDesconto(Double produtoDesconto) {
		this.produtoDesconto = produtoDesconto;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
}