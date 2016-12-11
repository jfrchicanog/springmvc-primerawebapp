package es.uma.informatica.springmvc.primerawebapp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
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
@EnableJpaRepositories(basePackages = "es.uma.informatica.springmvc.primerawebapp.repositories")
public class WebApplicationContextConfig extends WebMvcConfigurerAdapter { 
	
	@Bean("transactionManager")
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
	    result.setJpaProperties(jpaProviderProperties());
	    
		return result;
	}
	
	private Properties jpaProviderProperties() {
		Properties result = new Properties();
		result.put("javax.persistence.schema-generation.database.action", "none");
		return result;
	}
	
	@Bean 
	@Profile("test")
	public DataSource dataSource() { 
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); 
		EmbeddedDatabase db = builder 
				.setType(EmbeddedDatabaseType.HSQL) 
				.build(); 
		return db; 
	} 
	
	@Bean 
	@Profile("default")
	public DataSource realDataSource() throws NamingException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sample?zeroDateTimeBehavior=convertToNull");
		dataSource.setUsername("app");
		dataSource.setPassword("app");
		return dataSource;

		/*
		JndiTemplate jndi = new JndiTemplate();
        return (DataSource) jndi.lookup("java:/ecplus");*/
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
	
