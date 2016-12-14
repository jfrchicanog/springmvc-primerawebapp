package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uma.informatica.springmvc.primerawebapp.domain.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("usuarios")
	private List<Usuario> usuarios;
	
	@Autowired
	@Qualifier("usuarioSesion")
	private Usuario usuarioSesion;
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet (@ModelAttribute("usuario") Usuario usuario) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPost (Model model, HttpServletRequest req, @ModelAttribute("usuario") Usuario usuario) {
		if (usuarios.contains(usuario)) {
			usuarioSesion.setUser(usuario.getUser());
			usuarioSesion.setPassword(usuario.getPassword());
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
