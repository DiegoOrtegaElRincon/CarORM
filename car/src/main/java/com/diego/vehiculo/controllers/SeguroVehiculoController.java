package com.diego.vehiculo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.vehiculo.entity.models.SeguroVehiculo;
import com.diego.vehiculo.entity.services.ISeguroVehiculoService;



@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class SeguroVehiculoController {

	@Autowired
	ISeguroVehiculoService seguroVehiculoService;

	@GetMapping("/segurovehiculo")
	public List<SeguroVehiculo> getAllCars() {
		return seguroVehiculoService.getAll();
	}

	@GetMapping("/segurovehiculo/{id}")
	public SeguroVehiculo getCar(@PathVariable(value = "id") long id) {
		return seguroVehiculoService.get(id);
	}

	@PostMapping("/segurovehiculo")
	public void add(SeguroVehiculo car) {
		seguroVehiculoService.post(car);
	}

	@PutMapping("/segurovehiculo/{id}")
	public void update(SeguroVehiculo car, @PathVariable(value = "id") long id) {
		seguroVehiculoService.put(car, id);
	}

	@DeleteMapping("/segurovehiculo/{id}")
	public void deleteCar(@PathVariable(value = "id") long id) {
		seguroVehiculoService.delete(id);
	}
}