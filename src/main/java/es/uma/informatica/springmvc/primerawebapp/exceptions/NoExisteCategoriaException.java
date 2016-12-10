package es.uma.informatica.springmvc.primerawebapp.exceptions;

public class NoExisteCategoriaException extends RuntimeException {
	private String categoria;
	
	public NoExisteCategoriaException(String categoria) {
		setCategoria(categoria);
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
