package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cargo")
public class cargo {

	@Id
	@Column(name = "IdCargo")
	private int idCargo;
	
	@Column(name = "Cargo")
	private String nomCargo;
	
	//Relacion de Cargo a Empleados
	@OneToMany(mappedBy = "cargEmpleado")
	private List<empleados> listaEmpleados;

	//
	
	public int getIdCargo() {
		return idCargo;
	}

	public void setIdCargo(int idCargo) {
		this.idCargo = idCargo;
	}

	public String getNomCargo() {
		return nomCargo;
	}

	public void setNomCargo(String nomCargo) {
		this.nomCargo = nomCargo;
	}

	public List<empleados> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<empleados> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
}
