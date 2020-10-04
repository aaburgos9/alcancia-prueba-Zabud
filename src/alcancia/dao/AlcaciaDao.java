/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcancia.dao;

import alcancia.bo.Alcancia;
import alcancia.conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author andres
 */
public class AlcaciaDao {

    Conectar conexion = new Conectar();

    public String agregarMoneda(Alcancia alcancia) {
        PreparedStatement stmt = null;
        Connection con = null;
        try {
            con = this.conexion.getConexion();
            String query = "INSERT INTO alcancia(moneda) value (?);";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, alcancia.getMoneda());
            stmt.execute();
            this.conexion.cierraConexion();
        } catch (SQLException e) {
            System.err.println(e);
            return "Error al guardar moneda";
        }
        return "Guardado con exito!!";
    }

    public Integer consultarMonedas(int moneda) {
        PreparedStatement stmt = null;
        Connection con = null;
        int resultado = 0;
        try {
            con = this.conexion.getConexion();
            String query = "SELECT count(moneda) as moneda FROM alcancia.alcancia where moneda = ?;";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, moneda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("moneda");
            }
            this.conexion.cierraConexion();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }

    public Integer sumaMonedas(int moneda) {
        PreparedStatement stmt = null;
        Connection con = null;
        int resultado = 0;
        try {
            con = this.conexion.getConexion();
            String query = "SELECT sum(moneda) as valor FROM alcancia.alcancia where moneda = ?;";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, moneda);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("valor");
            }
            this.conexion.cierraConexion();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }
     public Integer saldoMonedas() {
        PreparedStatement stmt = null;
        Connection con = null;
        int resultado = 0;
        try {
            con = this.conexion.getConexion();
            String query = "SELECT sum(moneda) as total FROM alcancia.alcancia;";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("total");
            }
            this.conexion.cierraConexion();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }
          public Integer cantidadMonedas() {
        PreparedStatement stmt = null;
        Connection con = null;
        int resultado = 0;
        try {
            con = this.conexion.getConexion();
            String query = "SELECT count(moneda) as cantidad FROM alcancia.alcancia;";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                resultado = rs.getInt("cantidad");
            }
            this.conexion.cierraConexion();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return resultado;
    }


}
