
package br.unipar.flashcar.database.repository;

import br.unipar.flashcar.database.DatabaseConnection;
import br.unipar.flashcar.exception.NaoCadastradoException;
import br.unipar.flashcar.model.Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* @author leoal */
public class ModeloRepository {
    
    private String INSERT = "INSERT INTO MODELO (nome,marca_id) VALUES (?,?);";
    private String UPDATE = "UPDATE MODELO SET nome = ? , marca_id = ? WHERE id = ?;";
    private String DELETE = "DELETE MODELO WHERE id = ?;";
    private String FIND_BY_ID = "SELECT id, nome, marca_id from MODELO where id = ?;";
    private String FIND_ALL = "SELECT id, nome, marca_id from MODELO;";
    
    public void insert(Modelo modelo) throws SQLException, NaoCadastradoException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        MarcaRepository marca = new MarcaRepository();
        
        try {
            
            if (!(marca.findById(modelo.getId()).getId()>0)) {
                throw new NaoCadastradoException();
            }

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, modelo.getNome());
            ps.setInt(2, modelo.getMarca().getId());
            ps.execute();
            
        } finally {
            if(ps!= null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }            
        }
    }
    
    public ArrayList<Modelo> findAll() throws SQLException {
        Connection conn         = null;
        PreparedStatement ps    = null;
        ResultSet rs            = null;
        ArrayList<Modelo> listaResultado = new ArrayList<>();
        
        MarcaRepository marca = new MarcaRepository();
        
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_ALL);   
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelo modelo = new Modelo();
                modelo.setNome(rs.getString("nome"));
                modelo.setId(rs.getInt("id"));
                modelo.setMarca(marca.findById(rs.getInt("marca_id")));
                
                listaResultado.add(modelo);                
            }
            
        } finally {
            if(rs!= null){
                rs.close();
            }
            if(ps!= null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }            
        }
        return listaResultado;
    }
    
    public void delete (Modelo modelo) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, modelo.getId());
            ps.execute();
            
        } finally {
            if(ps!= null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }            
        }
    }
    
    public void update (Modelo modelo) throws SQLException, NaoCadastradoException {
        Connection conn = null;
        PreparedStatement ps = null;
        
        MarcaRepository marca = new MarcaRepository();
        
        try {
            
            if (!(marca.findById(modelo.getId()).getId()>0)) {
                throw new NaoCadastradoException();
            }

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, modelo.getNome());
            ps.setInt(2, modelo.getMarca().getId());
            ps.setInt(3, modelo.getId());
            ps.execute();
            
        } finally {
            if(ps!= null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }            
        }
    }
    
    public Modelo findById(int id) throws SQLException {
        Connection conn         = null;
        PreparedStatement ps    = null;
        ResultSet rs            = null;
        Modelo resultado         = new Modelo();
        
        MarcaRepository marca = new MarcaRepository();
        
        try {

            conn = new DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID); 
            ps.setInt(1,id);
            rs = ps.executeQuery();
            
            while(rs.next()){                
                resultado.setNome(rs.getString("nome"));
                resultado.setId(rs.getInt("id"));
                resultado.setMarca(marca.findById(rs.getInt("marca_id")));
            }
            
        } finally {
            if(rs!= null){
                rs.close();
            }
            if(ps!= null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }            
        }
        return resultado;
    }
    
}
