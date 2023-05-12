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
@Table(name = "Establecimiento")
public class establecimiento {

	@Id
	@Column(name = "idEstablecimiento")
	private int idEstablecimiento;
	
	@Column(name = "nomEstablecimiento")
	private String nom_Establecimiento;
	
	@Column(name = "telefonoEstablecimiento")
	private String telefonoEstableci;
	
	//RELACION DE MUCHOS A UNO EN ZONA DE REPARTO
	@ManyToOne
	@JoinColumn(name = "idZonaReparto")
	private zonaReparto zonRepEstab;
	
	@Column(name = "sobreNosotros")
	private String sobNosot;
	
	//RELACION DE UNO A MUCHOS EN COMBPROBANTE DE PAGOS
	@OneToMany(mappedBy = "establecimientoLoc")
	private List<comprobante_de_pago> listaComprobanteEst;

	//
	
	public int getIdEstablecimiento() {
		return idEstablecimiento;
	}

	public void setIdEstablecimiento(int idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public String getNom_Establecimiento() {
		return nom_Establecimiento;
	}

	public void setNom_Establecimiento(String nom_Establecimiento) {
		this.nom_Establecimiento = nom_Establecimiento;
	}

	public String getTelefonoEstableci() {
		return telefonoEstableci;
	}

	public void setTelefonoEstableci(String telefonoEstableci) {
		this.telefonoEstableci = telefonoEstableci;
	}

	public zonaReparto getzonRepEstab() {
		return zonRepEstab;
	}

	public void setzonRepEstab(zonaReparto zonRepEstab) {
		this.zonRepEstab = zonRepEstab;
	}

	public String getSobNosot() {
		return sobNosot;
	}

	public void setSobNosot(String sobNosot) {
		this.sobNosot = sobNosot;
	}

	public List<comprobante_de_pago> getListaComprobanteEst() {
		return listaComprobanteEst;
	}

	public void setListaComprobanteEst(List<comprobante_de_pago> listaComprobanteEst) {
		this.listaComprobanteEst = listaComprobanteEst;
	}
	
}
