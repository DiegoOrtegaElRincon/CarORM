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
@Table(name = "historial_mantenimiento")
public class HistorialMantenimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "vehiculo", unique = true)
	private Vehiculo vehiculo;
	@Column(name="fechaMantenimiento")
	private String fechaMantenimiento;
	@Column(name="descripcionMantenimiento")
	private String descripcionMantenimiento;
	@Column(name="costo")
	private double costo;

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

	public String getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	public void setFechaMantenimiento(String fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	public String getDescripcionMantenimiento() {
		return descripcionMantenimiento;
	}

	public void setDescripcionMantenimiento(String descripcionMantenimiento) {
		this.descripcionMantenimiento = descripcionMantenimiento;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
}
