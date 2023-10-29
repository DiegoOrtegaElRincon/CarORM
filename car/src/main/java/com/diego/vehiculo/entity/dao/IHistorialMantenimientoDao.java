package com.diego.vehiculo.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.diego.vehiculo.entity.models.HistorialMantenimiento;

public interface IHistorialMantenimientoDao extends CrudRepository<HistorialMantenimiento, Long> {
}

