package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class producto {

	@Id
	@Column(name = "codProd")
	private int codProd;
	
	@Column(name = "nomPro")
	private String nomPro;
	
	@Column(name = "precioPro")
	private double precioPro;
	
	//RELACION DE UNO A MUCHOS CON DETALLE DE PROMO 	
	@OneToMany(mappedBy = "detallePromocion")
	private List<detallePromo> listaProductoPromo;
	
	//RELACION DE UNO MUCHOS A UNO CON CATEGORIA DE PRODUCTO
	@ManyToOne
	@JoinColumn(name = "Id_CatProd")
	private cat_producto catProducto;
	
	//RELACION DE UNO A MUCHOS CON DETALLE DE PEDIDO
	@OneToMany(mappedBy = "detallePedidoProducto")
	private List<detalle_de_pedido> listaDetallePedido;

	//
	
	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}

	public String getNomPro() {
		return nomPro;
	}

	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
	}

	public double getPrecioPro() {
		return precioPro;
	}

	public void setPrecioPro(double precioPro) {
		this.precioPro = precioPro;
	}

	public List<detallePromo> getListaProductoPromo() {
		return listaProductoPromo;
	}

	public void setListaProductoPromo(List<detallePromo> listaProductoPromo) {
		this.listaProductoPromo = listaProductoPromo;
	}

	public cat_producto getCatProducto() {
		return catProducto;
	}

	public void setCatProducto(cat_producto catProducto) {
		this.catProducto = catProducto;
	}

	public List<detalle_de_pedido> getListaDetallePedido() {
		return listaDetallePedido;
	}

	public void setListaDetallePedido(List<detalle_de_pedido> listaDetallePedido) {
		this.listaDetallePedido = listaDetallePedido;
	}
	
	
}
