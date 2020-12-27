/*
 * Classe referente ao Ator Gerente e a entidade Gerente!
 * 
 * 
 */
package lojaCd.bean;

/**
 *
 * @author eduardo
 * @version 0.8
 * @since 27/03/2020
 */
public class Gerente {
    private String nome;
    private String senha;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
