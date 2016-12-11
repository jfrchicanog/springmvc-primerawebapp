package es.uma.informatica.springmvc.primerawebapp.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto;
import es.uma.informatica.springmvc.primerawebapp.service.ProductService;

@Configuration
@EnableWebMvc 
@ComponentScan("es.uma.informatica.springmvc.primerawebapp")
@EnableTransactionManagement
public class TestApplicationContextConfig {
	
	@Bean
	@Profile("test")
	public ProductService mockProductService(List<Producto> productos) {
		return new ProductService() {
			@Override
			public void save(Producto product) {
			}
			
			@Override
			public List<Producto> findAllProducts() {
				return productos;
			}

			@Override
			public Producto findOne(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
