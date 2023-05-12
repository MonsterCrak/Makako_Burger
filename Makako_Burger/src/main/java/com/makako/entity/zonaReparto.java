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
@Table(name = "ZonaReparto")
public class zonaReparto {
	
	@Id
	@Column(name = "idZonaReparto")
	private String idZonaReparto;
	
	//RELACION DE MUCHOS A UNO CON DISTRITO
	@ManyToOne
	@JoinColumn(name = "idDistrito")
	private distrito dist;
	
	@Column(name = "latitud")
	private String latitud;
	
	@Column(name = "longitud")
	private String longitud;
	
	//RELACION DE UNO A MUCHOS CON ESTABLECIMIENTO
	@OneToMany(mappedBy = "zonRepEstab")
	private List<establecimiento> listaEstablecimientoxZona;
	
	//RELACION DE UNO A MUCHOS CON HOJA DE ENVIO	
	@OneToMany(mappedBy = "zonaRepHoja")
	private List<hojaEnvio> listaHojaZona;

	//
	
	public String getIdZonaReparto() {
		return idZonaReparto;
	}

	public void setIdZonaReparto(String idZonaReparto) {
		this.idZonaReparto = idZonaReparto;
	}

	public distrito getDist() {
		return dist;
	}

	public void setDist(distrito dist) {
		this.dist = dist;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public List<establecimiento> getListaEstablecimientoxZona() {
		return listaEstablecimientoxZona;
	}

	public void setListaEstablecimientoxZona(List<establecimiento> listaEstablecimientoxZona) {
		this.listaEstablecimientoxZona = listaEstablecimientoxZona;
	}

	public List<hojaEnvio> getListaHojaZona() {
		return listaHojaZona;
	}

	public void setListaHojaZona(List<hojaEnvio> listaHojaZona) {
		this.listaHojaZona = listaHojaZona;
	}
	
	

}
