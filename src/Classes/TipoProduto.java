/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lorena
 */
public class TipoProduto {
    
    String nome;
    
    public void CadastrarTipo(String nome) {                                              
        // ao clicar em cadastrar ele seta no banco de dados os valores dos campos nome, endereco, celular  e telefone;
        Connection con;
        try{
            con = Conexao.getConnection();
            Statement statement = con.createStatement();
           
            String query = "INSERT INTO tipoproduto(" +
               "descricao)VALUES(' " +
               nome + "')" ;                       
                    
            int result = statement.executeUpdate(query);
                if ( result == 1 ){
                  JOptionPane.showMessageDialog(
                  null, "A inserção foi um sucesso.", "Aviso",JOptionPane.PLAIN_MESSAGE );
                }
        }catch(SQLException ex){
             // a linha a baixo exibe a mensagem de falha ao conectar no banco
            JOptionPane.showMessageDialog(
                  null, "Falha ao conectar banco de dados", "Aviso",
                  JOptionPane.PLAIN_MESSAGE );
        }            
    } 
    
    
    
    
}
