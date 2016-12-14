package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uma.informatica.springmvc.primerawebapp.domain.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private List<Usuario> usuarios;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet (@ModelAttribute("usuario") Usuario usuario) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost (Model model, HttpServletRequest req, @ModelAttribute("usuario") Usuario usuario) {
		if (usuarios.contains(usuario)) {
			req.getSession().setAttribute("user", usuario);
			return "redirect:/";
		} else {
			model.addAttribute("error", "Error de autenticación");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout (HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}

}
