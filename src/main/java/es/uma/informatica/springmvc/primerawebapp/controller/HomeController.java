package es.uma.informatica.springmvc.primerawebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.uma.informatica.springmvc.primerawebapp.domain.Usuario; 

@Controller 
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	@Qualifier("usuarioSesion")
	private Usuario usuarioSesion;
	
	@RequestMapping 
	public String welcome(HttpServletRequest req, Model model) {

		model.addAttribute("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		model.addAttribute("eslogan", "Compre Albosque, compre al mejor"); 
		
		model.addAttribute("user", usuarioSesion);
		
		
		/*System.out.println("user:"+user);
		System.out.println("user.user:"+user.getUser());*/
	
		return "welcome"; 
	} 
} 