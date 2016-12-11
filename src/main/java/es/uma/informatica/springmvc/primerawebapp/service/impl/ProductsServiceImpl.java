package es.uma.informatica.springmvc.primerawebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.repositories.ProductRepository;
import es.uma.informatica.springmvc.primerawebapp.service.ProductService;

@Service
@Profile("default")
@Transactional
public class ProductsServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repositorio;
	
	@Override
	public List<Producto> findAllProducts() {
		return Lists.newArrayList(repositorio.findAll());
	}
	
	@Override
	public void save (Producto product) {
		repositorio.save(product);
	}

	@Override
	public Producto findOne(Long id) {
		return repositorio.findOne(id);
	}

}
