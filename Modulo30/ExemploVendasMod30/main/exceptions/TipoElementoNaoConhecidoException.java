package ExemploVendasMod30.main.exceptions;

public class TipoElementoNaoConhecidoException extends Exception {

    public TipoElementoNaoConhecidoException(String msg) {
        this(msg, null);
    }

    public TipoElementoNaoConhecidoException(String msg, Throwable e) {
        super(msg, e);
    }


}
