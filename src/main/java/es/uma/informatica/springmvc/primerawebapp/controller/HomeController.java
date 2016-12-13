package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto; 

@Controller 
public class HomeController {
	@Autowired
	private List<Producto> productos; 

	@RequestMapping("/productos") 
	public ModelAndView productos() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		modelAndView.addObject("eslogan", "Compre Albosque, compre al mejor"); 
		modelAndView.addObject("productos", productos);
		
		modelAndView.setViewName("productos");

		return modelAndView; 
	}
	
	@RequestMapping("/productos/{categoria}") 
	public ModelAndView productosPorCategoria(@PathVariable("categoria") String categoria) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		modelAndView.addObject("eslogan", "Compre Albosque, compre al mejor"); 
		
		List<Producto> productosFiltrados = productos.stream()
				.filter(p->p.getCategoria().equalsIgnoreCase(categoria))
				.collect(Collectors.toList());
		
		modelAndView.addObject("productos", productosFiltrados);
		
		modelAndView.setViewName("productos");

		return modelAndView; 
	}
	
	@RequestMapping("/producto") 
	public ModelAndView producto(@RequestParam("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();
		
		Optional<Producto> producto = productos.stream()
		.filter(p->p.getId()==id)
		.findFirst();
		
		modelAndView.addObject("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		modelAndView.addObject("eslogan", "Compre Albosque, compre al mejor"); 
		modelAndView.addObject("producto", producto.isPresent()?producto.get():null);
		
		modelAndView.setViewName("producto");

		return modelAndView; 
	}
	
	@RequestMapping("/")
	public String welcome(Model model) {
		model.addAttribute("saludo", "¡Bienvenidos a Supermercados Albosque!");
		model.addAttribute("eslogan", "Compre Albosque, compre al mejor");
		return "welcome";
		
	}
} 