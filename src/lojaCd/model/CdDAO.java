/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lojaCd.bean.Cd;
import lojaCd.libs.ConnectionFactory;
import lojaCd.view.TelaInicial;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author eduardo
 * @version 0.3.5
 * @since 27/03/2020
 */
public class CdDAO {
    private TelaInicial tli;
    private PreparedStatement stmt;
    private String sql;
    public boolean adicionarCds(Cd cd){
      sql = "INSERT INTO tbl_cd(titulo,preco,gerero,autor,descricao,estoque,image)VALUES(?,?,?,?,?,?,?)";
      try{
         stmt = ConnectionFactory.getConnection().prepareStatement(sql);
         stmt.setString(1, cd.getTitulo());
         stmt.setDouble(2, cd.getPreco());
         stmt.setString(3, cd.getGenero());
         stmt.setString(4, cd.getAutor());
         stmt.setString(5, cd.getDescricao());
         stmt.setInt(6, cd.getEstoque());
         stmt.setString(7, cd.getFoto());
         stmt.execute();
         stmt.close();
         return true;
      }catch(SQLException e){
          System.out.println(e);
         return false;
      }
    }
    public void pesquisarCds(String c , javax.swing.JTable t){
        tli = new TelaInicial();
        //System.out.println(tli.campoPesquisa.getText() +" verda : "+ c.charAt(0));
        String d = String.valueOf(c.charAt(0));
        
        Cd cd = new Cd();
        List<Cd> cds = new ArrayList();
        //System.out.println(tli.jComboBoxClassificar.getSelectedIndex()+" "+c);
          sql = "SELECT titulo,preco,autor,descricao FROM tbl_cd WHERE titulo LIKE '"+d.toUpperCase()+"%'";
        if(tli.jComboBoxClassificar.getSelectedIndex() == 1){
          sql = "SELECT titulo,preco,autor,descricao FROM tbl_cd ORDER BY preco DESC";
        }if(tli.jComboBoxClassificar.getSelectedIndex() == 2){
          sql = "SELECT titulo,preco,autor,descricao FROM tbl_cd ORDER BY preco";
        }
       
        try {
              stmt = ConnectionFactory.getConnection().prepareStatement(sql);
              
              ResultSet rs = stmt.executeQuery();
            int i = 0;
             
             
              t.setModel(DbUtils.resultSetToTableModel(rs));
              stmt.close();
//            while(rs.next()){
//               
//              cd.setNome(rs.getString("nome"));
//              cd.setValue(rs.getDouble("preco"));
//              cds.add(cd);
//            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
            //throw new RuntimeException("Erro ao pegar no banco de dados!");
        }
    }
//    public List<Cd> pegarCds(){
//       
//        String sql = "SELECT * FROM cd ";
//        
//    }
    public String getPathOfImage(String titulo){
         //System.out.println(titulo);
            sql = "SELECT image FROM tbl_cd WHERE titulo=?";
        try {
            stmt = ConnectionFactory.getConnection().prepareStatement(sql);
            stmt.setString(1, titulo);
            
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
               titulo = rs.getString("image");
            }
            return titulo;    
        } catch (SQLException ex) {
            System.out.println(ex);
            return "/lojaCd/imagens/cds/noCd.jpg";
        }
        
    }
}
