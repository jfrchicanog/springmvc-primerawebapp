package es.uma.informatica.springmvc.primerawebapp.config;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import es.uma.informatica.springmvc.primerawebapp.domain.Producto; 

@Configuration 
@EnableWebMvc 
@ComponentScan("es.uma.informatica.springmvc.primerawebapp")
@EnableTransactionManagement
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter { 
	
	@Bean
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource) {
		LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
		result.setDataSource(datasource);
		result.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	    result.setJpaDialect(new HibernateJpaDialect());
	    result.setPackagesToScan("es.uma.informatica.springmvc.primerawebapp.domain");
		
		return result;
	}
	
	@Bean 
	public DataSource dataSource() { 
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); 
		EmbeddedDatabase db = builder 
				.setType(EmbeddedDatabaseType.HSQL) 
				.build(); 
		return db; 
	} 
	
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
	@Profile("default")
	public List<Producto> getProductos() {
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
	
	@Bean
	@Profile("test")
	public List<Producto> getProductos1() {
		List<Producto> resultado = new ArrayList<>();
		Producto producto = new Producto();
		producto.setNombre("Leche");
		producto.setDescripcion("Pura leche de vaca. Procede del Valle de los Pedroches");
		producto.setPrecio(1.50);
		producto.setCategoria("Lácteo");
		producto.setId(1L);
		
		resultado.add(producto);
		
		return resultado;
	}
	
	@Bean 
    public MessageSource messageSource() {  
       ResourceBundleMessageSource resource = new ResourceBundleMessageSource(); 
       resource.setBasename("messages"); 
       return resource;     
    }
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("/resources/images/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("idioma");
		registry.addInterceptor(interceptor);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		return localeResolver;
	}
	
	@Bean(name = "validator") 
    public LocalValidatorFactoryBean validator() { 
       LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean(); 
       bean.setValidationMessageSource(messageSource()); 
       return bean; 
    } 

	@Override 
	public Validator getValidator(){ 
		return validator(); 
	} 
} 
	
