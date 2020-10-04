/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcancia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class Conectar {

    private static final String URL = "jdbc:mysql://localhost:3306/alcancia";   
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection conn = null;
    private final String driverClassName = "com.mysql.jdbc.Driver";
   
    public Connection getConexion() {
        try {
            Class.forName(this.driverClassName);      
            this.conn = DriverManager.getConnection(URL, USER, PASS);            

        } catch (ClassNotFoundException | SQLException err) {
            System.out.println("Error " + err.getMessage());
            return conn = null;
        }
        return conn;
    }
    //Cerrar la conexion
    
    public void cierraConexion() throws SQLException {
        this.conn.close();
    }

}



/**
 * 
 * CREATE TABLE `alcancia`.`alcancia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `moneda` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

 */