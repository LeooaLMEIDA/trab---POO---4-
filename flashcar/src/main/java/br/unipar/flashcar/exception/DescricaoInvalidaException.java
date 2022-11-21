
package br.unipar.flashcar.exception;

/* @author leoal */
public class DescricaoInvalidaException extends Exception {

    public DescricaoInvalidaException() {
        super("Descrição vazia ou inválida. Verique!");
    }    
    
}
