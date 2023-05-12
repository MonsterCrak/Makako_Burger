package com.makako.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="DNI")
public class dni {

	@Id
	@Column(name = "Dni")
	private int dni;
	
	//RELACION DE UNO A UNO EN EMPLEADO
	@OneToOne(mappedBy = "empleadoDni")
	private empleados empleadoDNIAsignado;
	
	//RELACION DE UNO A UNNO EN USUARIOS
	@OneToOne(mappedBy = "dniUsuario")
	private usuario usuarioDNIAsignado;
	
	//RELACION DE UNO A UNO EN CLIENTE
	@OneToOne(mappedBy =  "dniCliente")
	private cliente clienteDNIAsignado;

	//
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public empleados getEmpleadoDNIAsignado() {
		return empleadoDNIAsignado;
	}

	public void setEmpleadoDNIAsignado(empleados empleadoDNIAsignado) {
		this.empleadoDNIAsignado = empleadoDNIAsignado;
	}

	public usuario getUsuarioDNIAsignado() {
		return usuarioDNIAsignado;
	}

	public void setUsuarioDNIAsignado(usuario usuarioDNIAsignado) {
		this.usuarioDNIAsignado = usuarioDNIAsignado;
	}

	public cliente getClienteDNIAsignado() {
		return clienteDNIAsignado;
	}

	public void setClienteDNIAsignado(cliente clienteDNIAsignado) {
		this.clienteDNIAsignado = clienteDNIAsignado;
	}
	
	
	
	
}
