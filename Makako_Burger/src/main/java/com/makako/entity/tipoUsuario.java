package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipoUsuario")
public class tipoUsuario {

	@Id
	@Column(name = "idTipoUsuario")
	private int idTipoUsuario;
	
	@Column(name = "nomTipoUsuario")
	private String nomTipUsu;
	
	//RELACION DE UNO A MUCHOS CON USUARIO
	@OneToMany(mappedBy = "tipoUsuario")
	private List<usuario> listaUsuarios;

	//
	
	public int getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(int idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNomTipUsu() {
		return nomTipUsu;
	}

	public void setNomTipUsu(String nomTipUsu) {
		this.nomTipUsu = nomTipUsu;
	}

	public List<usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
}
