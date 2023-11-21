package br.com.bellacabral.vendas.online.exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -8603027700687042323L;
	
	public BadRequestException(String message) {
        super(message);
    }

}
