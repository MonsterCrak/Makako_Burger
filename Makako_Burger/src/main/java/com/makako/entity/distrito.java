package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Distrito")
public class distrito {

	@Id
	@Column(name="idDistrito", unique = true)
	private int idDistrito;
	
	@Column(name = "nomDistrito")
	private String nomDistrito;
	
	//RELACION DE UNO A MUCHOS EN ZONA DE REPARTO
	@OneToMany(mappedBy = "dist")
	private List<zonaReparto> listaZonaxDis;

	//
	
	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNomDistrito() {
		return nomDistrito;
	}

	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}

	public List<zonaReparto> getListaZonaxDis() {
		return listaZonaxDis;
	}

	public void setListaZonaxDis(List<zonaReparto> listaZonaxDis) {
		this.listaZonaxDis = listaZonaxDis;
	}
	
	
	
}
