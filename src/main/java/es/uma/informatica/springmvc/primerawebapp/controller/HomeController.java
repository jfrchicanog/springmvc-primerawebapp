package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto; 

@Controller 
public class HomeController {
	@Autowired
	private List<Producto> productos; 

	@RequestMapping("/") 
	public String welcome(Model model) {

		model.addAttribute("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		model.addAttribute("eslogan", "Compre Albosque, compre al mejor"); 
		model.addAttribute("productos", productos);

		return "welcome"; 
	} 
} 