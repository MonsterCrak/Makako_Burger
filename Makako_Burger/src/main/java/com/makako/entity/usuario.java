package com.makako.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class usuario {

	@Id
	@Column(name = "idUsuario")
	private int idUsu;
		
	//RELACION DE UNO A UNO CON DNI
	@OneToOne
	@JoinColumn(name = "Dni")
	private dni dniUsuario; 
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "contraseña")
	private String contrasenia;
	
	//RELACION DE MUCHOS A UNO CON TIPO DE USUARIO
	@ManyToOne
	@JoinColumn(name = "idTipoUsuario")
	private tipoUsuario tipoUsuario;

	//
	
	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public dni getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(dni dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public tipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(tipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
