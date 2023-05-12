package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "metodorecojo")
public class metodoRecojo {
	
	@Id
	@Column(name = "codMetodoRecojo")
	private int codMetReco;
	
	@Column(name = "nomTipoRecojo")
	private String nomTipoRecojo;
	
	//RELACION DE UNO A MUCHOS CON PEDIDO
	@OneToMany(mappedBy = "metRecojoPedido")
	private List<pedido> listaPedidos;

	//
	
	public int getCodMetReco() {
		return codMetReco;
	}

	public void setCodMetReco(int codMetReco) {
		this.codMetReco = codMetReco;
	}

	public String getNomTipoRecojo() {
		return nomTipoRecojo;
	}

	public void setNomTipoRecojo(String nomTipoRecojo) {
		this.nomTipoRecojo = nomTipoRecojo;
	}

	public List<pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	

	
}
