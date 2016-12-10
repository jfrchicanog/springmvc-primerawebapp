package es.uma.informatica.springmvc.primerawebapp.repositories;

import java.util.List;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

public interface ProductRepository {
	public List<Producto> findAll();
	public void save(Producto product);
}
