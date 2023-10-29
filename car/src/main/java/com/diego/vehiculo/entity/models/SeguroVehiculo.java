package com.diego.vehiculo.entity.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seguros_vehiculos")
public class SeguroVehiculo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "vehiculo", unique = true)
	private Vehiculo vehiculo;
	@Column(name="compañiaDeSeguros")
	private String compañiaDeSeguros;
	@Column(name="fechaInicio")
	private String fechaInicio;
	@Column(name="fechaVencimiento")
	private String fechaVencimiento;
	@Column(name="tipoDeCobertura")
	private String tipoDeCobertura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getCompañiaDeSeguros() {
		return compañiaDeSeguros;
	}

	public void setCompañiaDeSeguros(String compañiaDeSeguros) {
		this.compañiaDeSeguros = compañiaDeSeguros;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoDeCobertura() {
		return tipoDeCobertura;
	}

	public void setTipoDeCobertura(String tipoDeCobertura) {
		this.tipoDeCobertura = tipoDeCobertura;
	}
}
