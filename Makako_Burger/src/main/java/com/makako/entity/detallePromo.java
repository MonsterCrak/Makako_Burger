package com.makako.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "codDetallePromo")
public class detallePromo {

	@Id
	@Column(name = "codDetallePromo")
	private int codDetallePromo;
	
	//RELACION DE MUCHOS A UNO EN PROMOCION
	@ManyToOne
	@JoinColumn(name = "codPromo")
	private promocion promo;//Nombre de la as
	
	//RELACION DE MUCHOS A UNO EN PRODUCTO
	@ManyToOne
	@JoinColumn(name = "codPro")
	private producto detallePromocion;
	
	@Column(name = "cantidad")
	private int cantidadDetalle;

	//
	
	public int getCodDetallePromo() {
		return codDetallePromo;
	}

	public void setCodDetallePromo(int codDetallePromo) {
		this.codDetallePromo = codDetallePromo;
	}

	public promocion getPromo() {
		return promo;
	}

	public void setPromo(promocion promo) {
		this.promo = promo;
	}

	public producto getDetallePromocion() {
		return detallePromocion;
	}

	public void setDetallePromocion(producto detallePromocion) {
		this.detallePromocion = detallePromocion;
	}

	public int getCantidadDetalle() {
		return cantidadDetalle;
	}

	public void setCantidadDetalle(int cantidadDetalle) {
		this.cantidadDetalle = cantidadDetalle;
	}
	
	
	
}
