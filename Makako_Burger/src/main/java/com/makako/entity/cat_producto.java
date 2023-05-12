package com.makako.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cat_Producto")
public class cat_producto {

	@Id
	@Column(name = "Id_CatProd")
	private int idCatProd;
	
	@Column(name = "nombre_CatProd")
	private String nombreCatProd;
	
	//Relación de Categoria A Productos
	@OneToMany(mappedBy = "catProducto")
	private List<producto> listaProducto_Cate;

	//
	
	public int getIdCatProd() {
		return idCatProd;
	}

	public void setIdCatProd(int idCatProd) {
		this.idCatProd = idCatProd;
	}

	public String getNombreCatProd() {
		return nombreCatProd;
	}

	public void setNombreCatProd(String nombreCatProd) {
		this.nombreCatProd = nombreCatProd;
	}

	public List<producto> getListaProducto_Cate() {
		return listaProducto_Cate;
	}

	public void setListaProducto_Cate(List<producto> listaProducto_Cate) {
		this.listaProducto_Cate = listaProducto_Cate;
	}

	
	
}
