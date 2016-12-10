package es.uma.informatica.springmvc.primerawebapp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Producto product) {
		// TODO Auto-generated method stub

	}

}
