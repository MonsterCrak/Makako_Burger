package com.makako.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class pedido {
	
	@Id
	@Column(name = "codPedido")
	private int codPedido;
	
	@Column(name = "fecPedido")
	private LocalDate fechaPed;
	
	//RELACION DE MUCHOS A UNO CON CLIENTE
	@ManyToOne
	@JoinColumn(name = "idCliene")
	private cliente clientePedido;
	
	@Column(name = "precTotPedido")
	private double precioTotalPedido;
	
	//RELACIUON DE MUCHOS A UNO CON ESTADO PEDIDO
	@ManyToOne
	@JoinColumn(name = "codEstadoPedido")
	private estadoPedido estadoPedidos;
	
	//RELACION DE MUCHOS A UNO CON METODO RECOJO
	@ManyToOne
	@JoinColumn(name = "codMetodoRecojo")
	private metodoRecojo metRecojoPedido;
	
	//RELACION  DE MUCHOS A UNO CON METODO DE PAGO
	@ManyToOne
	@JoinColumn(name = "codMetPago")
	private metPago metPagoPedido;

	//RELACIÓN DE UNO A MUCHOS CON DETALLE DE PEDIDO
	@OneToMany(mappedBy = "pedDetPed")
	private List<detalle_de_pedido> listaDetPed;
	
	//RELACION DE UNO A MUCHOS CON COMPROBANTE DE PAGO
	@OneToMany(mappedBy = "pedComprobante")
	private List<comprobante_de_pago> listaComprobantePago;
	
	//RELACION DE UNO A MUCHOS CON HOJA DE ENVIO
	@OneToMany(mappedBy = "pedHojaEnvio")
	private List<hojaEnvio> listaPedHoja;
	
	//RELACION DE UNO A MUCHOS CON RECLAMOS
	@OneToMany(mappedBy = "pedReclamo")
	private List<reclamos> listaReclamoPed;

	//
	
	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public LocalDate getFechaPed() {
		return fechaPed;
	}

	public void setFechaPed(LocalDate fechaPed) {
		this.fechaPed = fechaPed;
	}

	public cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(cliente clientePedido) {
		this.clientePedido = clientePedido;
	}

	public double getPrecioTotalPedido() {
		return precioTotalPedido;
	}

	public void setPrecioTotalPedido(double precioTotalPedido) {
		this.precioTotalPedido = precioTotalPedido;
	}

	public estadoPedido getEstadoPedidos() {
		return estadoPedidos;
	}

	public void setEstadoPedidos(estadoPedido estadoPedidos) {
		this.estadoPedidos = estadoPedidos;
	}

	public metodoRecojo getMetRecojoPedido() {
		return metRecojoPedido;
	}

	public void setMetRecojoPedido(metodoRecojo metRecojoPedido) {
		this.metRecojoPedido = metRecojoPedido;
	}

	public metPago getMetPagoPedido() {
		return metPagoPedido;
	}

	public void setMetPagoPedido(metPago metPagoPedido) {
		this.metPagoPedido = metPagoPedido;
	}

	public List<detalle_de_pedido> getListaDetPed() {
		return listaDetPed;
	}

	public void setListaDetPed(List<detalle_de_pedido> listaDetPed) {
		this.listaDetPed = listaDetPed;
	}

	public List<comprobante_de_pago> getListaComprobantePago() {
		return listaComprobantePago;
	}

	public void setListaComprobantePago(List<comprobante_de_pago> listaComprobantePago) {
		this.listaComprobantePago = listaComprobantePago;
	}

	public List<hojaEnvio> getListaPedHoja() {
		return listaPedHoja;
	}

	public void setListaPedHoja(List<hojaEnvio> listaPedHoja) {
		this.listaPedHoja = listaPedHoja;
	}

	public List<reclamos> getListaReclamoPed() {
		return listaReclamoPed;
	}

	public void setListaReclamoPed(List<reclamos> listaReclamoPed) {
		this.listaReclamoPed = listaReclamoPed;
	}
	
	
}
