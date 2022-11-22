package br.unipar.flashcar;

import br.unipar.flashcar.exception.DescricaoInvalidaException;
import br.unipar.flashcar.exception.NaoCadastradoException;
import br.unipar.flashcar.model.Cor;
import br.unipar.flashcar.model.Marca;
import br.unipar.flashcar.model.Modelo;
import br.unipar.flashcar.service.CorService;
import br.unipar.flashcar.service.MarcaService;
import br.unipar.flashcar.service.ModeloService;
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
            
            Marca fiat = new Marca();
            fiat.setId(1);
            fiat.setNome("Fiat");
            
            Marca chevrolet = new Marca();
            chevrolet.setId(2);
            chevrolet.setNome("Chevrolet");
            
            Marca volks = new Marca();
            volks.setId(3);
            volks.setNome("Volkswagen");
            
            Modelo uno = new Modelo();
            uno.setNome("Uno");
            uno.setMarca(fiat);
            
            Modelo gol = new Modelo();
            gol.setNome("Gol");
            gol.setMarca(volks);
            
            Modelo cruze = new Modelo();
            cruze.setNome("Cruze");
            cruze.setMarca(chevrolet);
            
            MarcaService servicoMarca = new MarcaService();
            servicoMarca.insert(volks);
            servicoMarca.insert(chevrolet);
            servicoMarca.insert(fiat);
            
            ModeloService servicoModelo =  new ModeloService();
            servicoModelo.insert(gol);
            servicoModelo.insert(uno);
            servicoModelo.insert(cruze);
            
            //corService.delete();
            
        } catch (DescricaoInvalidaException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NaoCadastradoException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
}
