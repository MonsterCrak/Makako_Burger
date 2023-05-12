package com.makako.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comprobante_de_pago")
public class comprobante_de_pago {
	
	@Id
	@Column(name = "codComprobante")
	private int codCompro;
	
	//RElacion de Muchos a uno con Establecimiento
	@ManyToOne
	@JoinColumn(name = "idEstablecimiento")
	private establecimiento establecimientoLoc;
	
	//RElacion de Muchos a uno con Pedido
	@ManyToOne
	@JoinColumn(name = "codPedido")
	private pedido pedComprobante;
	
	@Column(name = "fecEmitido")
	private LocalDate fecEmision;
	
	@Column(name = "precTotPedido")
	private double precioTotal;
	
	@Column(name = "precCostoEnvio")
	private double precioCostoEnv;

	//
	
	public int getCodCompro() {
		return codCompro;
	}

	public void setCodCompro(int codCompro) {
		this.codCompro = codCompro;
	}

	public establecimiento getEstablecimientoLoc() {
		return establecimientoLoc;
	}

	public void setEstablecimientoLoc(establecimiento establecimientoLoc) {
		this.establecimientoLoc = establecimientoLoc;
	}

	public pedido getPedComprobante() {
		return pedComprobante;
	}

	public void setPedComprobante(pedido pedComprobante) {
		this.pedComprobante = pedComprobante;
	}

	public LocalDate getFecEmision() {
		return fecEmision;
	}

	public void setFecEmision(LocalDate fecEmision) {
		this.fecEmision = fecEmision;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPrecioCostoEnv() {
		return precioCostoEnv;
	}

	public void setPrecioCostoEnv(double precioCostoEnv) {
		this.precioCostoEnv = precioCostoEnv;
	}
	
	

}
