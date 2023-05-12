package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class cliente {
	
	@Id
	@Column(name = "idCliente")
	private String idCliente;
	
	@Column(name = "nomCliente")
	private String nomCli;
	
	@Column(name = "apeCliente")
	private String apeCli;
	
	//RElación de uno a uno con DNI
	@OneToOne
	@JoinColumn(name ="Dni")
	private dni dniCliente;
	
	//Relación de Uno A Muchos con Pedido
	@OneToMany(mappedBy = "clientePedido")
	private List<pedido> listaPedidoCliente;
	
	//Relación de uno a muchos con Reclamos
	@OneToMany(mappedBy = "clienteReclamo")
	private List<reclamos> listaReclamoCliente;

	//
	
	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomCli() {
		return nomCli;
	}

	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}

	public String getApeCli() {
		return apeCli;
	}

	public void setApeCli(String apeCli) {
		this.apeCli = apeCli;
	}

	public dni getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(dni dniCliente) {
		this.dniCliente = dniCliente;
	}

	public List<pedido> getListaPedidoCliente() {
		return listaPedidoCliente;
	}

	public void setListaPedidoCliente(List<pedido> listaPedidoCliente) {
		this.listaPedidoCliente = listaPedidoCliente;
	}

	public List<reclamos> getListaReclamoCliente() {
		return listaReclamoCliente;
	}

	public void setListaReclamoCliente(List<reclamos> listaReclamoCliente) {
		this.listaReclamoCliente = listaReclamoCliente;
	}

	

}
