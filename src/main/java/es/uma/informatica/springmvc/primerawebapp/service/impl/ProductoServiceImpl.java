package es.uma.informatica.springmvc.primerawebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private List<Producto> productos; 
	
	@Override
	public List<Producto> findAll() {
		return productos;
	}

	@Override
	public void save(Producto producto) {
		productos.add(producto);
	}

}
