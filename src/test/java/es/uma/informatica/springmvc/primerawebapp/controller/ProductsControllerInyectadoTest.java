package es.uma.informatica.springmvc.primerawebapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.uma.informatica.springmvc.primerawebapp.config.WebApplicationContextConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=WebApplicationContextConfig.class)
@WebAppConfiguration
//@ActiveProfiles("test")
public class ProductsControllerInyectadoTest {
	@Autowired 
	private WebApplicationContext wac;
	@Autowired
	private MockHttpSession session;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
	}
	
	@Test	
	public void test() throws Exception {
		mockMvc.perform(get("/productos"))
		
			.andExpect(model().attributeExists("productos"))
			.andExpect(model().attribute("productos", IsCollectionWithSize.hasSize(1)))
			.andExpect(view().name("productos"));
	}

}
