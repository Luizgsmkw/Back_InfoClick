package com.api.projetoFinal.domain;

import com.api.projetoFinal.domain.dtos.EmpreendedorDTO;

import com.api.projetoFinal.domain.enums.Perfil;
import com.api.projetoFinal.domain.enums.Ramo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Empreendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpreendedor;
    private String nomeNegocio;
    @CNPJ
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String email;
    private String password;
    private Perfil perfil;
    private String celular;
    private Ramo ramo;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    
       
    @JsonIgnore
    @OneToOne(mappedBy = "empreendedor")
    private Loja loja;

    public Empreendedor(EmpreendedorDTO obj){
        super();
        this.idEmpreendedor = obj.getIdEmpreendedor();
        this.nomeNegocio = obj.getNomeNegocio();
        this.cnpj = obj.getCnpj();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.perfil = obj.getPerfil();
        this.celular = obj.getCelular();
        this.ramo = obj.getRamo();
        this.cep = obj.getCep();
        this.estado = obj.getEstado();
        this.cidade = obj.getCidade();
        this.bairro = obj.getBairro();
        this.rua = obj.getRua();
        this.numero = obj.getNumero();
    }

    public Empreendedor(Integer idEmpreendedor, String nomeNegocio, @CNPJ String cnpj, String email, String password,
            String celular, Ramo ramo, String cep, String estado, String cidade, String bairro, String rua,
            String numero) {
        this.idEmpreendedor = idEmpreendedor;
        this.nomeNegocio = nomeNegocio;
        this.cnpj = cnpj;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.ramo = ramo;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        setPerfil(Perfil.EMPREENDEDOR);

    }

   
	public Empreendedor() {
        super();
        setPerfil(Perfil.EMPREENDEDOR);
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Ramo getRamo() {
        return ramo;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    public Integer getIdEmpreendedor() {
        return idEmpreendedor;
    }

    public void setIdEmpreendedor(Integer idEmpreendedor) {
        this.idEmpreendedor = idEmpreendedor;
    }

    public String getNomeNegocio() {
        return nomeNegocio;
    }

    public void setNomeNegocio(String nomeNegocio) {
        this.nomeNegocio = nomeNegocio;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
        Empreendedor that = (Empreendedor) o;
        return idEmpreendedor.equals(that.idEmpreendedor) && cnpj.equals(that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpreendedor, cnpj);
    }
}
