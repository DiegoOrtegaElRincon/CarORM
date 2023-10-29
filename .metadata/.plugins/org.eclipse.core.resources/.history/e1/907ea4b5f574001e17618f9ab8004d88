package com.diego.vehiculo.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.vehiculo.entity.dao.ISeguroVehiculoDao;
import com.diego.vehiculo.entity.models.SeguroVehiculo;
@Service
public class ISeguroVehiculoServiceImpl implements ISeguroVehiculoService {

	@Autowired
	ISeguroVehiculoDao seguroVehiculoDao;

	@Override
	public SeguroVehiculo get(long id) {
		return seguroVehiculoDao.findById(id).get();
	}

	@Override
	public List<SeguroVehiculo> getAll() {
		return (List<SeguroVehiculo>) seguroVehiculoDao.findAll();
	}

	@Override
	public void post(SeguroVehiculo seguro) {
		seguroVehiculoDao.save(seguro);

	}

	@Override
	public void put(SeguroVehiculo seguro, long id) {
		seguroVehiculoDao.findById(id).ifPresent((x) -> {
			seguro.setId(id);
			seguroVehiculoDao.save(seguro);
		});
	}

	@Override
	public void delete(long id) {
		seguroVehiculoDao.deleteById(id);
	}

}
