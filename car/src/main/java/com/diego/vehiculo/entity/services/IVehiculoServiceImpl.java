package com.diego.vehiculo.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.vehiculo.entity.dao.IVehiculoDao;
import com.diego.vehiculo.entity.models.Vehiculo;

@Service
public class IVehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoDao vehiculoDao;

	@Override
	public Vehiculo get(long id) {
		return vehiculoDao.findById(id).get();
	}

	@Override
	public List<Vehiculo> getAll() {
		return (List<Vehiculo>) vehiculoDao.findAll();

	}

	@Override
	public void post(Vehiculo car) {
		vehiculoDao.save(car);
	}

	@Override
	public void put(Vehiculo car, long id) {
		vehiculoDao.findById(id).ifPresent((x) -> {
			car.setId(id);
			vehiculoDao.save(car);
		});

	}

	@Override
	public void delete(long id) {
		vehiculoDao.deleteById(id);

	}

}
