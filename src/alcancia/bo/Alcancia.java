/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcancia.bo;

/**
 *
 * @author andres
 */
public class Alcancia {

    private int id;

    private int moneda;

    public Alcancia(int moneda) {
        this.moneda = moneda;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoneda() {
        return moneda;
    }

    public void setMoneda(int moneda) {
        this.moneda = moneda;
    }
}
