package com.makako.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "promocion")
public class promocion {

	@Id
	@Column(name = "codPromo")
	private int codPromo;
	
	@Column(name = "precioPromo")
	private double precioPromo;
	
	@Column(name = "fechaVigencia")
	private Date fechaVig;
	
	@Column(name = "imagenCombo")
	private String imagenCombo;
	
	//En el mappeedBy va la asociacion que le colocamos al objeto que salió de la relacion en la entidad adecuada.
	//RELACION DE UNO A MUCHOS CON DETALLE DE PROMO
	@OneToMany(mappedBy = "promo")
	private List<detallePromo> listaDetalle;

	//RELACION DE UNO A MUCHOS CON DETALLE DE PEDIDO
	@OneToMany(mappedBy = "detallePedPromo")
	private List<detalle_de_pedido> listaPromocion;

	//
	
	public int getCodPromo() {
		return codPromo;
	}

	public void setCodPromo(int codPromo) {
		this.codPromo = codPromo;
	}

	public double getPrecioPromo() {
		return precioPromo;
	}

	public void setPrecioPromo(double precioPromo) {
		this.precioPromo = precioPromo;
	}

	public Date getFechaVig() {
		return fechaVig;
	}

	public void setFechaVig(Date fechaVig) {
		this.fechaVig = fechaVig;
	}

	public String getImagenCombo() {
		return imagenCombo;
	}

	public void setImagenCombo(String imagenCombo) {
		this.imagenCombo = imagenCombo;
	}

	public List<detallePromo> getListaDetalle() {
		return listaDetalle;
	}

	public void setListaDetalle(List<detallePromo> listaDetalle) {
		this.listaDetalle = listaDetalle;
	}

	public List<detalle_de_pedido> getListaPromocion() {
		return listaPromocion;
	}

	public void setListaPromocion(List<detalle_de_pedido> listaPromocion) {
		this.listaPromocion = listaPromocion;
	}
	
	
}
