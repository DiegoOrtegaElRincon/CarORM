package com.diego.vehiculo.entity.services;

import java.util.List;

import com.diego.vehiculo.entity.models.SeguroVehiculo;

public interface ISeguroVehiculoService {

	public SeguroVehiculo get(long id);

	public List<SeguroVehiculo> getAll();

	public void post(SeguroVehiculo car);

	public void put(SeguroVehiculo car, long id);

	public void delete(long id);
}