package es.uma.informatica.springmvc.primerawebapp.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.service.ProductService;

@RestController
@RequestMapping("/rest")
public class ProductsRestController {
	@Autowired
	private ProductService productsService; 
	
	@RequestMapping(value = "/productos", method=RequestMethod.GET)
	public List<Producto> allProducts() {
		return productsService.findAllProducts();
	}

	@RequestMapping(value = "/producto/{id}", method=RequestMethod.GET) 
	public Producto oneProduct(@PathVariable("id") Long id) {
		return productsService.findOne(id);
	}
	
	@RequestMapping(value = "/productos/add", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.CREATED)
	public void processAddNewProductForm(@RequestBody Producto newProduct) {
		productsService.save(newProduct);
	}

}
