package com.diego.vehiculo.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.vehiculo.entity.dao.IHistorialMantenimientoDao;
import com.diego.vehiculo.entity.models.HistorialMantenimiento;
@Service
public class IHistorialMantenimientoServiceImpl implements IHistorialMantenimientoService {

	@Autowired
	IHistorialMantenimientoDao historialMantenimientoDao;

	@Override
	public HistorialMantenimiento get(long id) {
		return historialMantenimientoDao.findById(id).get();
	}

	@Override
	public List<HistorialMantenimiento> getAll() {
		return (List<HistorialMantenimiento>) historialMantenimientoDao.findAll();
	}

	@Override
	public void post(HistorialMantenimiento historial) {
		historialMantenimientoDao.save(historial);
	}

	@Override
	public void put(HistorialMantenimiento historial, long id) {
		historialMantenimientoDao.findById(id).ifPresent((x) ->{
			historial.setId(id);
			historialMantenimientoDao.save(historial);
		});
	}

	@Override
	public void delete(long id) {
		historialMantenimientoDao.deleteById(id);

	}

}
