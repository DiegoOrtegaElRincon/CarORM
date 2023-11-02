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

import com.diego.vehiculo.entity.models.HistorialMantenimiento;
import com.diego.vehiculo.entity.services.IHistorialMantenimientoService;

@RestController
@CrossOrigin(origins = "http://localhost:8100")
public class HistorialMantenimientoController {

	@Autowired
	IHistorialMantenimientoService historialMantenimientoService;

	@GetMapping("/historialmantenimiento")
	public List<HistorialMantenimiento> getAllCars() {
		return historialMantenimientoService.getAll();
	}

	@GetMapping("/historialmantenimiento/{id}")
	public HistorialMantenimiento getCar(@PathVariable(value = "id") long id) {
		return historialMantenimientoService.get(id);
	}

	@PostMapping("/historialmantenimiento")
	public void add(HistorialMantenimiento car) {
		historialMantenimientoService.post(car);
	}

	@PutMapping("/historialmantenimiento/{id}")
	public void update(HistorialMantenimiento car, @PathVariable(value = "id") long id) {
		historialMantenimientoService.put(car, id);
	}

	@DeleteMapping("/historialmantenimiento/{id}")
	public void deleteCar(@PathVariable(value = "id") long id) {
		historialMantenimientoService.delete(id);
	}
}
