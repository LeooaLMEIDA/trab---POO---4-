
package br.unipar.flashcar.model;

import java.util.ArrayList;
import lombok.Data;

/* @author leoal */

@Data
public class Marca {
    private int id;
    private String nome;
    private ArrayList<Modelo> listaModelos = new ArrayList();
    
    
    
}
