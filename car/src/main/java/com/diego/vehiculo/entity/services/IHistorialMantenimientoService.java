package com.diego.vehiculo.entity.services;

import java.util.List;

import com.diego.vehiculo.entity.models.HistorialMantenimiento;

public interface IHistorialMantenimientoService {

	public HistorialMantenimiento get(long id);

	public List<HistorialMantenimiento> getAll();

	public void post(HistorialMantenimiento historial);

	public void put(HistorialMantenimiento historial, long id);

	public void delete(long id);
}