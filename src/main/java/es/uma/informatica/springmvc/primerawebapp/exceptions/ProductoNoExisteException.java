package es.uma.informatica.springmvc.primerawebapp.exceptions;

public class ProductoNoExisteException extends RuntimeException {
	private Long id;
	
	public ProductoNoExisteException ( Long id ) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	

}
