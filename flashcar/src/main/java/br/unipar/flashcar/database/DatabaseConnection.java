
package br.unipar.flashcar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* @author leoal */
public class DatabaseConnection {
    
    public Connection getConnection() throws SQLException{
        
        return DriverManager.getConnection(
                "jdbc:h2:H:\\Meu Drive\\Classroom\\PROGRAMACAO ORIENTADA"
                        + " A OBJETOS 2Serie-TURMA-A-ANÁLISE E DESENVOLVIMENTO"
                        + " DE SISTEMAS\\ConexaoBanco\\flashcar","","");
    }
    
}
