package com.diego.vehiculo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.vehiculo.entity.models.Vehiculo;
import com.diego.vehiculo.entity.services.IVehiculoService;

@RestController
public class VehiculoController {

	@Autowired
	IVehiculoService vehiculoService;

	@GetMapping("/vehiculo")
	public List<Vehiculo> getAllCars() {
		return vehiculoService.getAll();
	}

	@GetMapping("/vehiculo/{id}")
	public Vehiculo getCar(@PathVariable(value = "id") long id) {
		return vehiculoService.get(id);
	}

	@PostMapping("/vehiculo")
	public void add(Vehiculo car) {
		vehiculoService.post(car);
	}

	@PutMapping("/vehiculo")
	public void update(Vehiculo car, @PathVariable(value = "id") long id) {
		vehiculoService.put(car, id);
	}

}
