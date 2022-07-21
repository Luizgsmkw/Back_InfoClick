package com.api.projetoFinal.domain.dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.api.projetoFinal.domain.Loja;
import com.api.projetoFinal.domain.Produto;
import com.api.projetoFinal.domain.enums.Categoria;
import com.api.projetoFinal.domain.enums.Status;

public class ProdutoDTO extends Produto {

	private static final long serialVersionUID = 1L;

	protected Integer id;
	@NotNull(message = "O campo NAME não poderá ser nulo")
	protected String name;
	@NotNull(message = "O valor do produto não poderá ser nulo")
	protected Double produtoValor;
	@NotNull(message = "A descrição do produto não poderá ser nulo")
	protected String produtoDescricao;
	protected Categoria categoria;
	protected Integer produtoEstoque;
	protected Status status;
	protected String produtoImagem;
	protected Double produtoDesconto;
	protected Date dataCriacao;
	protected Date ultimaAtualizacao;

	protected Loja loja;
	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
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
		this.dataCriacao = obj.getDataCriacao();
		this.ultimaAtualizacao = obj.getUltimaAtualizacao();
		this.loja = obj.getLoja();
	}
	public Loja getLoja() {
		return loja;
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
		if(produtoDesconto >= 1){
			return  (produtoValor - (produtoValor * produtoDesconto / 100));
		}else{
			return produtoValor;
		}
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