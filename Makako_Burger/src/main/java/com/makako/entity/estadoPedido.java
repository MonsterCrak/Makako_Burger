package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estadospedido")
public class estadoPedido {
	
	@Id
	@Column(name = "codEstadoPedido")
	private int codEstadoPed;
	
	@Column(name = "nomTipoEstado")
	private String nomTipoEst;
	
	//RELACION de uno a muchos en pedido
	@OneToMany(mappedBy = "estadoPedidos")
	private List<pedido> listaPedidos;
	
	//RELACION DE UNO A MUCHOS EN HOJA DE ENVIO
	@OneToMany(mappedBy = "estadoHojaPed")
	private List<hojaEnvio> listaHojasxEstado;

	//
	
	public int getCodEstadoPed() {
		return codEstadoPed;
	}

	public void setCodEstadoPed(int codEstadoPed) {
		this.codEstadoPed = codEstadoPed;
	}

	public String getNomTipoEst() {
		return nomTipoEst;
	}

	public void setNomTipoEst(String nomTipoEst) {
		this.nomTipoEst = nomTipoEst;
	}

	public List<pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<hojaEnvio> getListaHojasxEstado() {
		return listaHojasxEstado;
	}

	public void setListaHojasxEstado(List<hojaEnvio> listaHojasxEstado) {
		this.listaHojasxEstado = listaHojasxEstado;
	}

	
	
}
