package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiporeclamo")
public class tipoReclamo {
	
	@Id
	@Column(name = "idTipoReclamo")
	private int codTipoRecla;
	
	@Column(name = "nomTipoReclamo")
	private String nomTipoRecla;
	
	//RELACION DE UNO A MUCHOS CON RECLAMOS
	@OneToMany(mappedBy = "tiposReclamo")
	private List<reclamos> listaReclamos;

	//
	
	public int getCodTipoRecla() {
		return codTipoRecla;
	}

	public void setCodTipoRecla(int codTipoRecla) {
		this.codTipoRecla = codTipoRecla;
	}

	public String getNomTipoRecla() {
		return nomTipoRecla;
	}

	public void setNomTipoRecla(String nomTipoRecla) {
		this.nomTipoRecla = nomTipoRecla;
	}

	public List<reclamos> getListaReclamos() {
		return listaReclamos;
	}

	public void setListaReclamos(List<reclamos> listaReclamos) {
		this.listaReclamos = listaReclamos;
	}
	
}
