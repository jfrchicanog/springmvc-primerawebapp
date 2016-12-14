package es.uma.informatica.springmvc.primerawebapp.service;

import java.util.List;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

public interface ProductoService {
	List<Producto> findAll();
	void save(Producto producto);
}
