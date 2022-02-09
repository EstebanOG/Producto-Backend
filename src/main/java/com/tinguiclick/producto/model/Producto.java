package com.tinguiclick.producto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Data
@Table( name = "producto")
public class Producto implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	private String descripcion;
	private String color;
	private double tamanio;
	private int valor;
	
}
