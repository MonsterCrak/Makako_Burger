package com.makako.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reclamos")
public class reclamos {

	@Id
	@Column(name = "numReclamo")
	private int numReclamo;
	
	@Column(name = "fechaReclamo")
	private LocalDate fechaRecla;
	
	@Column(name = "descripcionReclamo")
	private String descripcionRecla;
	
	//RELACION DE MUCHOS A UNO CO CLIENTE
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private cliente clienteReclamo;
	
	//RELACION DE MUCHOS A UNO CON TIPO DE RECLAMO
	@ManyToOne
	@JoinColumn(name = "idTipoReclamo")
	private tipoReclamo tiposReclamo;
	
	//RELACION DE MUCHOS A UNO CON PEDIDO
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private pedido pedReclamo;

	//
	
	public int getNumReclamo() {
		return numReclamo;
	}

	public void setNumReclamo(int numReclamo) {
		this.numReclamo = numReclamo;
	}

	public LocalDate getFechaRecla() {
		return fechaRecla;
	}

	public void setFechaRecla(LocalDate fechaRecla) {
		this.fechaRecla = fechaRecla;
	}

	public String getDescripcionRecla() {
		return descripcionRecla;
	}

	public void setDescripcionRecla(String descripcionRecla) {
		this.descripcionRecla = descripcionRecla;
	}

	public cliente getClienteReclamo() {
		return clienteReclamo;
	}

	public void setClienteReclamo(cliente clienteReclamo) {
		this.clienteReclamo = clienteReclamo;
	}

	public tipoReclamo getTiposReclamo() {
		return tiposReclamo;
	}

	public void setTiposReclamo(tipoReclamo tiposReclamo) {
		this.tiposReclamo = tiposReclamo;
	}

	public pedido getPedReclamo() {
		return pedReclamo;
	}

	public void setPedReclamo(pedido pedReclamo) {
		this.pedReclamo = pedReclamo;
	}
	
}
