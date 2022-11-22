package br.unipar.flashcar.service;

import br.unipar.flashcar.database.repository.ModeloRepository;
import br.unipar.flashcar.exception.DescricaoInvalidaException;
import br.unipar.flashcar.exception.NaoCadastradoException;
import br.unipar.flashcar.model.Modelo;
import java.sql.SQLException;
import java.util.ArrayList;

/* @author leoal */
public class ModeloService {
    private void valida(Modelo modelo) throws DescricaoInvalidaException{
        
        if (modelo.getNome() == null) {
            throw new DescricaoInvalidaException();
        }
        
        if (modelo.getNome().trim().length() == 0) {
            throw new DescricaoInvalidaException();
        }       
        
        if (modelo.getNome().trim().length() > 60) {
            throw new DescricaoInvalidaException();
        }
        
    }
    public void insert(Modelo modelo) throws DescricaoInvalidaException, SQLException, NaoCadastradoException{
        valida(modelo);
        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.insert(modelo);       
    }
    public ArrayList<Modelo> findAll() throws SQLException{
        ModeloRepository modeloRepository = new ModeloRepository();
        return modeloRepository.findAll();
    }
    public void delete(Modelo modelo) throws SQLException{
        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.delete(modelo);
    }
    public void update(Modelo modelo) throws SQLException, DescricaoInvalidaException, NaoCadastradoException{
        valida(modelo);
        ModeloRepository modeloRepository = new ModeloRepository();
        modeloRepository.update(modelo);
    }
    public Modelo findById(int id) throws SQLException{
        ModeloRepository modeloRepository = new ModeloRepository();
        return modeloRepository.findById(id);
    }
}
