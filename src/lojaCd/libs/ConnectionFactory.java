/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaCd.libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pi
 */
public final class ConnectionFactory {
    public static Connection getConnection(){
      
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/lojacd", "root", "");
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao conectar no Banco de dados!");
        }
    }
}
