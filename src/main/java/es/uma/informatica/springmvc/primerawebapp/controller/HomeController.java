package es.uma.informatica.springmvc.primerawebapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 
@RequestMapping("/")
public class HomeController {
	
	/*@Autowired
	private Usuario user;*/
	
	@RequestMapping 
	public String welcome(HttpServletRequest req, Model model) {

		model.addAttribute("saludo", "¡Bienvenidos a Supermercados Albosque!"); 
		model.addAttribute("eslogan", "Compre Albosque, compre al mejor"); 
		
		model.addAttribute("user", req.getAttribute("user"));
		
		
		/*System.out.println("user:"+user);
		System.out.println("user.user:"+user.getUser());*/
	
		return "welcome"; 
	} 
} 