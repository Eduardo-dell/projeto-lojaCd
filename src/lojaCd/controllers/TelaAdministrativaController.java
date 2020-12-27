/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import lojaCd.bean.Cd;
import lojaCd.model.CdDAO;
import lojaCd.model.GerenteDAO;
import lojaCd.view.TelaAdministrativa;
/**
 *
 * @author eduardo
 */
public class TelaAdministrativaController {
    private TelaAdministrativa tad;
    private String titulo;
    private String genero;
    private String autor;
    private String descricao;
    private double preco;
    private String foto;
    private int estoque;
    private CdDAO cdDao;
    private Cd cd;
    public TelaAdministrativaController() {
        this.cdDao = new CdDAO();
        cd = new Cd();
        this.tad = new TelaAdministrativa();
        init();
    }
    public void start(){
        this.tad.setVisible(true);
        this.tad.setResizable(false);
    }
    private void init(){
        this.tad.btnAdicionarCd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titulo = tad.campoTituloAdicionar.getText();
                genero = tad.campoGeneroAdicionar.getText();
                autor = tad.campoAutorAdicionar.getText();
                descricao = tad.campoDescricaoAdicionar.getText();
                preco = Double.parseDouble(tad.campoPrecoAdicionar.getText());
                if(!tad.campoFoto.getText().equals(""))
                foto = tad.campoFoto.getText();
                System.out.println(tad.jSpinnerEstoqueAdicionar.getValue());
                estoque = (int) tad.jSpinnerEstoqueAdicionar.getValue();
                cd.setTitulo(titulo);
                cd.setGenero(genero);
                cd.setAutor(autor);
                cd.setDescricao(descricao);
                cd.setPreco(preco);
                cd.setEstoque(estoque);
                if(!tad.campoFoto.getText().equals(""))
                cd.setFoto("/lojaCd/imagens/cds/"+foto);
                else
                    cd.setFoto("/lojaCd/imagens/cds/noCd.jpg");
                if(cdDao.adicionarCds(cd)){
                    JOptionPane.showMessageDialog(null, "Operação concluida", "Adicionar", JOptionPane.PLAIN_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Operação falha", "Adcionar", JOptionPane.PLAIN_MESSAGE);
                }
                
            }
        });
    }
    
    
}
