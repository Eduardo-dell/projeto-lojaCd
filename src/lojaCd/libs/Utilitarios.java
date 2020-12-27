/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.libs;

/**
 *
 * @author eduardo
 * @version 0.9
 * @since 03/04/2020
 */
public final class Utilitarios {
    private static boolean logged;
    private static String nomeUsuario;

    public static boolean isLogged() {
        return logged;
    }

    public static void setLogged(boolean logged) {
        Utilitarios.logged = logged;
    }

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nomeUsuario) {
        Utilitarios.nomeUsuario = nomeUsuario;
    }
    
    
    public static void setLogado(boolean log){
        logged = log;
    }
    public static boolean getLogado(){
        return logged;
    }
}
