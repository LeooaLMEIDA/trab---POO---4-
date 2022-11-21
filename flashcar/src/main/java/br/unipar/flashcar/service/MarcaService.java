
package br.unipar.flashcar.service;

import br.unipar.flashcar.database.repository.MarcaRepository;
import br.unipar.flashcar.exception.DescricaoInvalidaException;
import br.unipar.flashcar.model.Marca;
import java.sql.SQLException;
import java.util.ArrayList;

/* @author leoal */
public class MarcaService {
    
    private void valida(Marca marca) throws DescricaoInvalidaException{
        
        if (marca.getNome() == null) {
            throw new DescricaoInvalidaException();
        }
        
        if (marca.getNome().trim().length() == 0) {
            throw new DescricaoInvalidaException();
        }       
        
        if (marca.getNome().trim().length() > 60) {
            throw new DescricaoInvalidaException();
        }
        
    }
    public void insert(Marca marca) throws DescricaoInvalidaException, SQLException{
        valida(marca);
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.insert(marca);       
    }
    public ArrayList<Marca> findAll() throws SQLException{
        MarcaRepository marcaRepository = new MarcaRepository();
        return marcaRepository.findAll();
    }
    public void delete(Marca marca) throws SQLException{
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.delete(marca);
    }
    public void update(Marca marca) throws SQLException, DescricaoInvalidaException{
        valida(marca);
        MarcaRepository marcaRepository = new MarcaRepository();
        marcaRepository.update(marca);
    }
    public Marca findById(int id) throws SQLException{
        MarcaRepository marcaRepository = new MarcaRepository();
        return marcaRepository.findById(id);
    }
}
