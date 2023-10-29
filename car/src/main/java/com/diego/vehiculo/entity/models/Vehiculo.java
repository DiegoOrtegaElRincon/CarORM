package com.diego.vehiculo.entity.models;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@Column(name="ano_fabricacion")
	private String anoFabricacion;
	@Column(name="placa", unique=true)
	private String placa;

	@OneToOne(mappedBy = "vehiculo", cascade = {CascadeType.ALL})
	private SeguroVehiculo seguroVehiculo;

	@OneToOne(mappedBy = "vehiculo", cascade = {CascadeType.ALL})
	private HistorialMantenimiento historialMantenimiento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAñoFabricacion() {
		return anoFabricacion;
	}

	public void setAñoFabricacion(String añoFabricacion) {
		this.anoFabricacion = añoFabricacion;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public SeguroVehiculo getSeguroVehiculo() {
		return seguroVehiculo;
	}

	public void setSeguroVehiculo(SeguroVehiculo seguroVehiculo) {
		this.seguroVehiculo = seguroVehiculo;
	}

	public HistorialMantenimiento getHistorialMantenimiento() {
		return historialMantenimiento;
	}

	public void setHistorialMantenimiento(HistorialMantenimiento historialMantenimiento) {
		this.historialMantenimiento = historialMantenimiento;
	}

}
