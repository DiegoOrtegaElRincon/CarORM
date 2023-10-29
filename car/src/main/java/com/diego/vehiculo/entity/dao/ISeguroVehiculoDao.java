package com.diego.vehiculo.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.diego.vehiculo.entity.models.SeguroVehiculo;

public interface ISeguroVehiculoDao extends CrudRepository<SeguroVehiculo, Long> {
}

