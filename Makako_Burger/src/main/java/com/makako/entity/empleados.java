package com.makako.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleados")
public class empleados {

	@Id
	@Column(name = "ID_Empleado")
	private int codEmpleado;
	
	@Column(name = "nom_Empleado")
	private String nomEmple;
	
	@Column(name = "ape_Empleado")
	private String apeEmpleado;
	
	//RELACION DE MUCHOS A UNO EN CARGO
	@ManyToOne
	@JoinColumn(name = "IdCargo")
	private cargo cargEmpleado;
	
	@Column(name = "fechaRegistro_Empleado")
	private Date fechaReg_Emple;
	
	//RELACION DE UNO A UNO CON DNI
	@OneToOne
	@JoinColumn(name = "Dni")
	private dni empleadoDni;

	/**/
	
	public int getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNomEmple() {
		return nomEmple;
	}

	public void setNomEmple(String nomEmple) {
		this.nomEmple = nomEmple;
	}

	public String getApeEmpleado() {
		return apeEmpleado;
	}

	public void setApeEmpleado(String apeEmpleado) {
		this.apeEmpleado = apeEmpleado;
	}

	public cargo getCargEmpleado() {
		return cargEmpleado;
	}

	public void setCargEmpleado(cargo cargEmpleado) {
		this.cargEmpleado = cargEmpleado;
	}

	public Date getFechaReg_Emple() {
		return fechaReg_Emple;
	}

	public void setFechaReg_Emple(Date fechaReg_Emple) {
		this.fechaReg_Emple = fechaReg_Emple;
	}

	public dni getEmpleadoDni() {
		return empleadoDni;
	}

	public void setEmpleadoDni(dni empleadoDni) {
		this.empleadoDni = empleadoDni;
	}	
	
}
