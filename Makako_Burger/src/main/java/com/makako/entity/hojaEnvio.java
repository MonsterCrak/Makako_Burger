package com.makako.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "hoja_de_envio")
public class hojaEnvio {
	
	@Id
	@Column(name = "codHojaEnvio")
	private int codHoja;
	
	//RELACION DE MUCHOS A UNO CON ZONA DE REPARTO
	@ManyToOne
	@JoinColumn(name = "idZonaReparto")
	private zonaReparto zonaRepHoja;
	
	//RELACION DE MUCHOS A UNO CON PEDIDO
	@ManyToOne
	@JoinColumn(name = "codPEdido")
	private pedido pedHojaEnvio;
	
	@Column(name = "telefono")
	private String telefonoHoja;
		
	//RELACION DE MUCHOS A UNO CON ESTADO PEDIDO
	@ManyToOne
	@JoinColumn(name = "codEstadoPedido")
	private estadoPedido estadoHojaPed;

	//
	
	public int getCodHoja() {
		return codHoja;
	}

	public void setCodHoja(int codHoja) {
		this.codHoja = codHoja;
	}

	public zonaReparto getZonaRepHoja() {
		return zonaRepHoja;
	}

	public void setZonaRepHoja(zonaReparto zonaRepHoja) {
		this.zonaRepHoja = zonaRepHoja;
	}

	public pedido getPedHojaEnvio() {
		return pedHojaEnvio;
	}

	public void setPedHojaEnvio(pedido pedHojaEnvio) {
		this.pedHojaEnvio = pedHojaEnvio;
	}

	public String getTelefonoHoja() {
		return telefonoHoja;
	}

	public void setTelefonoHoja(String telefonoHoja) {
		this.telefonoHoja = telefonoHoja;
	}

	public estadoPedido getEstadoHojaPed() {
		return estadoHojaPed;
	}

	public void setEstadoHojaPed(estadoPedido estadoHojaPed) {
		this.estadoHojaPed = estadoHojaPed;
	}

	
}
