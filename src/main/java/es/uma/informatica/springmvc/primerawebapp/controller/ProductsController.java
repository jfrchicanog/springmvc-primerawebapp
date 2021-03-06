package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.exceptions.NoExisteCategoriaException;
import es.uma.informatica.springmvc.primerawebapp.service.ProductService; 

@Controller 
public class ProductsController {
	@Autowired
	private ProductService productsService; 
	
	@RequestMapping("/productos") 
	public String allProducts(Model model) {
		model.addAttribute("productos", productsService.findAllProducts());
		return "productos"; 
	}
	
	@RequestMapping("/productos/{categoria}") 
	public String productsOfCategory(@PathVariable("categoria") String categoria, Model model) {
		List<Producto> products = productsService.findAllProducts().stream()
				.filter(p->p.getCategoria().equals(categoria))
				.collect(Collectors.toList());
		if (products.isEmpty()) {
			throw new NoExisteCategoriaException(categoria);
		} else {
			model.addAttribute("productos", products);
			return "productos";
		}
	} 
	
	@RequestMapping("/producto") 
	public String oneProduct(@RequestParam("id") Long id, Model model) {
		Optional<Producto> producto = productsService.findAllProducts().stream()
				.filter(p->p.getId()==id)
				.findAny();
		model.addAttribute("producto", producto.isPresent()?producto.get():null);
		return "producto"; 
	}
	
	@RequestMapping(value = "/productos/add", method = RequestMethod.GET) 
	public String getAddNewProductForm(Model model) { 
		Producto newProduct = new Producto(); 
		model.addAttribute("nuevoProducto", newProduct); 
		return "addProduct"; 
	} 

	@RequestMapping(value = "/productos/add", method = RequestMethod.POST) 
	public String processAddNewProductForm(@ModelAttribute("nuevoProducto") Producto newProduct) {
		productsService.save(newProduct);
		return "redirect:/productos"; 
	}
	
	
	@ExceptionHandler(NoExisteCategoriaException.class)
	public ModelAndView error(HttpServletRequest request, NoExisteCategoriaException exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("errorPage");
		modelAndView.addObject("categoria", exception.getCategoria());
		return modelAndView;
	}
} 