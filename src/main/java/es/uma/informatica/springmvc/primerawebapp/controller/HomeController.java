package es.uma.informatica.springmvc.primerawebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping 
	public String welcome(Model model) {

		model.addAttribute("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		model.addAttribute("eslogan", "Compre Albosque, compre al mejor"); 
	
		return "productos"; 
	} 
} 