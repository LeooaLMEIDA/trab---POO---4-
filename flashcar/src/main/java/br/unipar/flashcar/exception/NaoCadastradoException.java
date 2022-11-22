/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.flashcar.exception;

/**
 *
 * @author leoal
 */
public class NaoCadastradoException extends Exception{

    public NaoCadastradoException() {
        super("O id da Marca não está cadastrado!");
    }
    
}
