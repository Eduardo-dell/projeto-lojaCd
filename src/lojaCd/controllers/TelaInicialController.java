/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import lojaCd.libs.Utilitarios;
import lojaCd.view.TelaInicial;

/**
 *
 * @author eduardo
 * @version 0.7
 * @since 21/03/2020
 */
public class TelaInicialController {
    TelaInicial tli;
    private String nome;
    public TelaInicialController() {
       tli = new TelaInicial();
       init();
    }
    private void init(){
       tli.btnComprarPuro.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              alterarTela(e);
              
           }
       });
    }
    public void start(String nomeUser){
       
       tli.setVisible(true);
       tli.nomeUser.setText(nomeUser);
       this.nome = nomeUser;
       Utilitarios.setNomeUsuario(nomeUser);
         /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }
    private void alterarTela(ActionEvent e){
       int res = JOptionPane.showConfirmDialog(tli.btnComprarPuro, "Deseja comprar "+tli.nomePuro.getText(), "", 2 ,JOptionPane.QUESTION_MESSAGE);
        if(res == JOptionPane.OK_OPTION){
            if(true){
                
              new TelaComprarController().start();
            }else{
              JOptionPane.showMessageDialog(tli.btnComprarPuro, "Só podem comprar Pessoas Cadastradas","Não Foi Possivel Realizar Pedido",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
       
       
       
    }
    
    
}
