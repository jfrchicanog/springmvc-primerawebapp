package es.uma.informatica.springmvc.primerawebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;

public interface ProductRepository extends CrudRepository<Producto,Long>{
}
