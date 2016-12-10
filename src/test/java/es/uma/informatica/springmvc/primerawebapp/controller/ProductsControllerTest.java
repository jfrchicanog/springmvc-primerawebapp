package es.uma.informatica.springmvc.primerawebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.exceptions.NoExisteCategoriaException;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

//@RunWith(JMockit.class)
public class ProductsControllerTest {

	@Test
	public void testProductsInModel(@Mocked Model model) {
		List<Producto> productos = getListaProductos();
		ProductsController controller = new ProductsController();
		ReflectionTestUtils.setField(controller, "productos", productos);
		new Expectations(){{
			model.addAttribute(anyString, productos.get(0));
		}};
		
		String view = controller.oneProduct(1L, model);
		Assert.assertEquals("producto", view);
		
	}
	
	@Test
	public void testPaginaError(@Mocked HttpServletRequest request, @Mocked NoExisteCategoriaException exception) {
		ProductsController controller = new ProductsController();
		new Expectations(){{
			exception.getCategoria(); result="Lácteo";
		}};
		
		ModelAndView mav = controller.error(request, exception);
		
		ModelAndViewAssert.assertViewName(mav, "errorPage");
		ModelAndViewAssert.assertModelAttributeAvailable(mav, "categoria");
		ModelAndViewAssert.assertModelAttributeValue(mav, "categoria", "Lácteo");
		
	}
	
	private List<Producto> getListaProductos() {
		List<Producto> resultado = new ArrayList<>();
		Producto producto = new Producto();
		producto.setNombre("Leche");
		producto.setDescripcion("Pura leche de vaca. Procede del Valle de los Pedroches");
		producto.setPrecio(1.50);
		producto.setCategoria("Lácteo");
		producto.setId(1L);
		
		resultado.add(producto);
		
		producto = new Producto();
		producto.setNombre("Atún");
		producto.setDescripcion("Conserva de atún de 250gr.");
		producto.setPrecio(1.00);
		producto.setCategoria("Conserva");
		producto.setId(2L);
		
		resultado.add(producto);
		
		return resultado;
		
	}

}
