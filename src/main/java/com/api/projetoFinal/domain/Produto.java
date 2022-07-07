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

import com.api.projetoFinal.domain.enums.Categoria;

@Entity
@Table(name="produtos")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;	

    @Column(name = "name")
    private String name;
    
    @Column(name ="produtoValor")
    private String produtoValor;

    @Column(name = "produtoDescricao")
    private String produtoDescricao; 
    
    
    @Column(name = "categoria_id")
    private Categoria categoria;
    
    @Column(name = "produtoEstoque")
    private int produtoEstoque;   

    @Column(name = "produtoStatus")
    private boolean produtoStatus;
    
    @Column(name = "produtoImagem")
    private String produtoImagem;
    
    @Column(name = "produtoDesconto")
    private float produtoDesconto;    

    @Column(name = "dataCriacao")
    @CreationTimestamp
    private Date dataCriacao;

    @Column(name = "ultimaAtualizacao")
    @UpdateTimestamp
    private Date ultimaAtualizacao;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
		

	public Produto(Integer id, String name, String produtoValor, String produtoDescricao, Categoria categoria,
			int produtoEstoque, boolean produtoStatus, String produtoImagem, float produtoDesconto, Date dataCriacao,
			Date ultimaAtualizacao) {
		super();
		this.id = id;
		this.name = name;
		this.produtoValor = produtoValor;
		this.produtoDescricao = produtoDescricao;
		this.categoria = categoria;
		this.produtoEstoque = produtoEstoque;
		this.produtoStatus = produtoStatus;
		this.produtoImagem = produtoImagem;
		this.produtoDesconto = produtoDesconto;
		this.dataCriacao = dataCriacao;
		this.ultimaAtualizacao = ultimaAtualizacao;
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

	public String getProdutoValor() {
		return produtoValor;
	}

	public void setProdutoValor(String produtoValor) {
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

	public int getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(int produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public boolean isProdutoStatus() {
		return produtoStatus;
	}

	public void setProdutoStatus(boolean produtoStatus) {
		this.produtoStatus = produtoStatus;
	}

	public String getProdutoImagem() {
		return produtoImagem;
	}

	public void setProdutoImagem(String produtoImagem) {
		this.produtoImagem = produtoImagem;
	}

	public float getProdutoDesconto() {
		return produtoDesconto;
	}

	public void setProdutoDesconto(float produtoDesconto) {
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
