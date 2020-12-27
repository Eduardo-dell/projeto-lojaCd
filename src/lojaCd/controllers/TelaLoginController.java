/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.controllers;

import java.awt.CardLayout;
import java.awt.Color;
import static java.lang.System.exit;
import javax.swing.JOptionPane;
import lojaCd.bean.Cliente;
import lojaCd.bean.Gerente;
import lojaCd.libs.Utilitarios;
import lojaCd.model.ClienteDao;
import lojaCd.model.GerenteDAO;
import lojaCd.view.TelaLogin;

/**
 *
 * @author eduardo
 * @version 0.5
 * @since 22/03/2020
 */
public class TelaLoginController {
   //definindo variaveis
    static TelaLogin tll = new TelaLogin();
    private static String nome;
    private static String email;
    private static String senha;
    private static String cpf;
    private static ClienteDao clienteDao;
    private static Cliente cliente;
    
   //inicializacao da tela
    public TelaLoginController() {
      tll.setVisible(true);
    }
    
    public static void login(){
      //--------iniciando variaveis---------
      
      nome = tll.campoNomeLogin.getText();
      email = tll.campoEmailLogin.getText();
      senha = String.valueOf(tll.campoSenhaLogin.getPassword());
//-----------testes-------------------------------
//        System.out.println("----------Entrada---------------");
//        System.out.println(tll.campoEmailLogin.getText());
//        System.out.println(tll.campoNomeLogin.getText());
//        System.out.println(tll.campoSenhaLogin.getText());
//        System.out.println("----------Final-----------------");
//------------fim testes----------------------------
      //------adicionando atributos----------

      //------verificando..------------
      //clienteDao.loginCliente(cliente)
      if(tll.entrarComoAdmin.isSelected()){
          Gerente gerente = new Gerente();
          gerente.setNome(nome);
          gerente.setSenha(senha);
          gerente.setEmail(email);
          GerenteDAO gerenteDao = new GerenteDAO();
          
          if(gerenteDao.loginGerente(gerente)){
            new TelaAdministrativaController().start();
            JOptionPane.showMessageDialog(null, "Bem Vindo "+gerente.getNome());
          }else{
              JOptionPane.showMessageDialog(null, "Cadastro mau sucedido!");
          }
      }else{
           cliente = new Cliente();
           clienteDao = new ClienteDao();
           cliente.setNome(nome);
           cliente.setEmail(email);
           cliente.setSenha(senha);
          if(clienteDao.loginCliente(cliente)){
                JOptionPane.showMessageDialog(null, "Bem Vindo "+cliente.getNome());
                Utilitarios.setLogado(true);
                new TelaInicialController().start(cliente.getNome());

                tll.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Cadastro mau sucedido!");
            }
      
      }
            
    }
    public static void adicionarCliente(){
      
      cliente = new Cliente();
      clienteDao = new ClienteDao();
      nome = tll.campoNomeCadastro.getText();
      email = tll.campoEmailCadastro.getText();
      senha = String.valueOf(tll.campoSenhaCadastro.getPassword());
      cpf = tll.campoCpfCadastro.getText();
      
      cliente.setNome(nome);
      cliente.setEmail(email);
      cliente.setSenha(senha);
      cliente.setCpf(cpf);
      
      if(clienteDao.adicionar(cliente)){
          Utilitarios.setLogado(true);
          JOptionPane.showMessageDialog(null, "Cadastrado com sucesso! Bem vindo "+cliente.getNome());
      }
      else{
          JOptionPane.showMessageDialog(null, "Cadastro mau sucedido!");
      }
    }
    public static void trocaSlide(int qualSlide){
       if(qualSlide == 0){
        CardLayout cl = (CardLayout) tll.SlideCarder.getLayout();
        cl.next(tll.SlideCarder);
        tll.panelLogo.setBackground(Color.BLACK);
       }
       if(qualSlide == 1){
        CardLayout cl = (CardLayout) tll.SlideCarder.getLayout();
        cl.previous(tll.SlideCarder);
        tll.panelLogo.setBackground(new Color(0,51,51));
       }
    }      
    
    
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              TelaLoginController tlc = new TelaLoginController();        
            }
        });
        
  
    }
}
