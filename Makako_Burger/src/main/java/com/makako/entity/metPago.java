package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "metpago")
public class metPago {
	
	@Id
	@Column(name = "codMetPago")
	private int codMetPago;
	
	@Column(name = "NomTipoPago")
	private String nomTipoPago;
	
	//RELACION DE MUCHOS A UNO CON METODO PAGO
	@OneToMany(mappedBy = "metPagoPedido")
	private List<pedido> listaPedidoPago;

	//
	
	public int getCodMetPago() {
		return codMetPago;
	}

	public void setCodMetPago(int codMetPago) {
		this.codMetPago = codMetPago;
	}

	public String getNomTipoPago() {
		return nomTipoPago;
	}

	public void setNomTipoPago(String nomTipoPago) {
		this.nomTipoPago = nomTipoPago;
	}

	public List<pedido> getListaPedidoPago() {
		return listaPedidoPago;
	}

	public void setListaPedidoPago(List<pedido> listaPedidoPago) {
		this.listaPedidoPago = listaPedidoPago;
	}

}
