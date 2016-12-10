package es.uma.informatica.springmvc.primerawebapp.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Producto> findAll() {
		TypedQuery<Producto> query = em.createNamedQuery("Producto.findAll", Producto.class);
		return query.getResultList();
	}

	@Override
	public void save(Producto product) {
		em.persist(product);
	}

}
