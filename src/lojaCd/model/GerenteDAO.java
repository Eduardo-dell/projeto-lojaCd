/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import lojaCd.bean.Gerente;
import lojaCd.libs.ConnectionFactory;

/**
 *
 * @author eduardo
 * @version 0.5
 * @since 27/03/2020
 */
public class GerenteDAO {
   private PreparedStatement stmt;
   public boolean loginGerente(Gerente e){
        
        String sql = "SELECT * FROM tbl_gerente WHERE senha=md5(?) OR nome=?";
        
        try {
            this.stmt = ConnectionFactory.getConnection().prepareStatement(sql);
            this.stmt.setString(1, e.getSenha());
            this.stmt.setString(2, e.getNome());
            ResultSet rs = this.stmt.executeQuery();
            
            int i = 0;    
            while(rs.next()){
// -----------------testes---------------------
//                System.out.println("-------Na classe------------");
//                System.out.println(e.getNome());
//                System.out.println(e.getEmail());
//                System.out.println(e.getSenha());
//                System.out.println(e.getNome().equalsIgnoreCase(rs.getString("nome")));
//                System.out.println("-------Na classe------------");
// ---------------fim dos testes-------------------
                //--------Inicia verificacao da conta no bd---------
                
                
                
                if(e.getNome().equalsIgnoreCase(rs.getString("nome"))){
                  i++;
                  
                }else{
                  JOptionPane.showMessageDialog(null, "Nome Inexistente no Banco de Dados","Nome Inválido!",JOptionPane.ERROR_MESSAGE);
                }
                //--------verificação da senha em md5------------
                try {
                    String nome = e.getSenha();
                    MessageDigest md = MessageDigest.getInstance("MD5");
                    md.update(nome.getBytes(),0,nome.length());
                    if(new BigInteger(1,md.digest()).toString(16).equalsIgnoreCase(rs.getString("senha"))){
                      i++;  
                    
                    }else{
                      JOptionPane.showMessageDialog(null, "Senha Incorreta ou Inexistente","Senha Inválida!",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoSuchAlgorithmException ex) {
                    System.out.println(ex);
                }
                //--------fim da verificação da senha em md5------------
                if(e.getEmail().equalsIgnoreCase(rs.getString("email"))){
                  
                  i++;
                }else{
                  JOptionPane.showMessageDialog(null, "Email Incorreto ou Inexistente","Email Invalido!",JOptionPane.ERROR_MESSAGE);  
                }
            }
            stmt.close();
            if(i == 3)
                return true;
            else
                return false;
             //--------Termina verificacao da conta no bd---------
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fazer Login! "+ex);
        }
       
    }
   
}
