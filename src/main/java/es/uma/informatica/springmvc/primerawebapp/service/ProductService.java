package es.uma.informatica.springmvc.primerawebapp.service;

import java.util.List;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

public interface ProductService {

	List<Producto> findAllProducts();

	void save(Producto product);

}