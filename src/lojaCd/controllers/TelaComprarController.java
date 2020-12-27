/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import lojaCd.libs.Utilitarios;
import lojaCd.model.ClienteDao;
import lojaCd.view.TelaComprar;
import lojaCd.view.TelaInicial;

/**
 *
 * @author eduardo
 */
public class TelaComprarController{
    private TelaComprar tc;
    private int apertado = 0;
    private ClienteDao clienteDao;
    
    
    public TelaComprarController() {
       tc = new TelaComprar();
       clienteDao = new ClienteDao();
       init();
       
    }
    public void start(){
      tc.setVisible(true);
      tc.setResizable(false);
    }
    private void init(){
      tc.gerarCodigo.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if(apertado == 0){
                btnReservarAction(e);
                apertado++;
              }else{
                  JOptionPane.showMessageDialog(tc.gerarCodigo, "Só se pode gerar código uma vez","Comando Inválido", JOptionPane.ERROR_MESSAGE);
              }
              
          }
      });
      tc.btnComprar.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              btnComprarAction();
          }
      });
    }
    private void btnComprarAction(){
      
    }
    private void btnReservarAction(ActionEvent e){
        Random randomNum = new Random();
        Random randomNum2 = new Random();
        int numHash = Integer.toString(randomNum.nextInt(100)+randomNum2.nextInt(100)).hashCode();
        
        tc.campoHash.setText(Integer.toString(TelaInicial.nomePuro.getText().hashCode()+numHash));
        clienteDao.reservaCompra(Utilitarios.getNomeUsuario(), TelaInicial.nomePuro.getText().hashCode()+numHash);
    }
}
