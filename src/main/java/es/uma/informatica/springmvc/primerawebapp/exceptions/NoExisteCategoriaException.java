package es.uma.informatica.springmvc.primerawebapp.exceptions;

public class NoExisteCategoriaException extends RuntimeException {
	private String categoria;
	
	public NoExisteCategoriaException(String categoria) {
		setCategoria(categoria);
	}

	public String getCategoria() {
		return categoria;
	}

	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
