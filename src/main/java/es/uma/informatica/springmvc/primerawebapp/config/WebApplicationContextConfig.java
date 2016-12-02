package es.uma.informatica.springmvc.primerawebapp.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto; 

@Configuration 
@EnableWebMvc 
@ComponentScan("es.uma.informatica.springmvc.primerawebapp") 
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter { 

	@Override 
	public void configureDefaultServletHandling (DefaultServletHandlerConfigurer configurer) { 
		configurer.enable(); 
	} 

	@Bean 
	public InternalResourceViewResolver getInternalResourceViewResolver() { 
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setViewClass(JstlView.class); 
		resolver.setPrefix("/WEB-INF/jsp/"); 
		resolver.setSuffix(".jsp"); 

		return resolver; 
	}
	
	@Bean
	public List<Producto> getProductos() {
		List<Producto> resultado = new ArrayList<>();
		Producto producto = new Producto();
		producto.setNombre("Leche");
		producto.setDescripcion("Pura leche de vaca. Procede del Valle de los Pedroches");
		producto.setPrecio(1.50);
		
		resultado.add(producto);
		
		producto = new Producto();
		producto.setNombre("Atún");
		producto.setDescripcion("Conserva de atún de 250gr.");
		producto.setPrecio(1.00);
		
		resultado.add(producto);
		
		return resultado;
	}
	
} 
