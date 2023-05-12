package com.makako.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="detalle_de_pedido")
public class detalle_de_pedido {

	@Id
	@Column(name = "numDetalle")
	private int codDetallePedido;
	
	@Column(name = "cant")
	private int cantidad;
	
	@Column(name = "precioPedidoTot")
	private double precioPedidoTotal;
	
	//Relacion de MUCHOS A UNO EN PROMOCION
	@ManyToOne
	@JoinColumn(name = "codPromo")
	private promocion detallePedPromo; 
	
	//RELACION DE MUCHOS A UNO DE PRODUCTO
	@ManyToOne
	@JoinColumn(name = "codPro")
	private producto detallePedidoProducto;
	
	//RELACION DE MUCHOS A UNO EN PEDIDO
	@ManyToOne
	@JoinColumn(name = "codPedido")
	private pedido pedDetPed;

	//
	
	public int getCodDetallePedido() {
		return codDetallePedido;
	}

	public void setCodDetallePedido(int codDetallePedido) {
		this.codDetallePedido = codDetallePedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioPedidoTotal() {
		return precioPedidoTotal;
	}

	public void setPrecioPedidoTotal(double precioPedidoTotal) {
		this.precioPedidoTotal = precioPedidoTotal;
	}

	public promocion getDetallePedPromo() {
		return detallePedPromo;
	}

	public void setDetallePedPromo(promocion detallePedPromo) {
		this.detallePedPromo = detallePedPromo;
	}

	public producto getDetallePedidoProducto() {
		return detallePedidoProducto;
	}

	public void setDetallePedidoProducto(producto detallePedidoProducto) {
		this.detallePedidoProducto = detallePedidoProducto;
	}

	public pedido getPedDetPed() {
		return pedDetPed;
	}

	public void setPedDetPed(pedido pedDetPed) {
		this.pedDetPed = pedDetPed;
	}

	
}
