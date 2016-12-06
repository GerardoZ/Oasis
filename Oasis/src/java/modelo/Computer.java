/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gerardojavierzaratepina
 */
public class Computer {
    private int computer_id;
    private String modName;
    private double priceSale;
    private String type;
    private Component[] components = new Component[5];

    public int getComputer_id() {
        return computer_id;
    }

    public void setComputer_id(int computer_id) {
        this.computer_id = computer_id;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
    }
    
    

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Component[] getComponents() {
        return components;
    }

    public void setComponents(Component[] components) {
        this.components = components;
    }
    
    
}
