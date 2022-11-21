package br.unipar.flashcar;

import br.unipar.flashcar.exception.DescricaoInvalidaException;
import br.unipar.flashcar.model.Cor;
import br.unipar.flashcar.service.CorService;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*@author leoal*/
public class Flashcar {

    public static void main(String[] args) {
        
        try {
            Cor azul = new Cor();
            azul.setDescricao("White");
            
            CorService corService = new CorService();
            corService.insert(azul);
            
            ArrayList<Cor> listaCores = corService.findAll();
            System.out.println(listaCores.toString());
            
            System.out.println(corService.findById(2).toString()); 
            
            //corService.delete();
            
        } catch (DescricaoInvalidaException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
}
