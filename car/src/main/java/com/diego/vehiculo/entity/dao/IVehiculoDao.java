package com.diego.vehiculo.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.diego.vehiculo.entity.models.Vehiculo;

public interface IVehiculoDao extends CrudRepository<Vehiculo, Long>{

}
