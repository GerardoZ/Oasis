/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ComponentDAO;
import dao.ComputerDAO;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Component;
import modelo.Computer;

/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@ViewScoped
public class SaleBean {
    private List<Component> lstMother = new ArrayList<>();
    private List<Component> lstRam = new ArrayList<>();
    private List<Component> lstDD = new ArrayList<>();
    private List<Component> lstCPU = new ArrayList<>();
    private List<Component> lstGPU = new ArrayList<>();
    
    private List<String> lstComputers = new ArrayList<>();
    private Computer c = new Computer();
    private String selectedComputer = "1 - Razr Blade";
    
    private List<Computer> lstDetails = new ArrayList<>();
    private double total = 0;

    
    /**
     * Creates a new instance of SaleBean
     */
    public SaleBean() throws Exception {
        lstMother = this.getComponentByType("Tarjeta madre");
        lstRam = this.getComponentByType("Memoria Ram");
        lstCPU = this.getComponentByType("Procesador");
        lstGPU = this.getComponentByType("Tarjeta grafica");
        lstDD = this.getComponentByType("DiscoDuro");
        lstComputers = this.getComputers();
        this.selectComputer();
        
    }
    
    public List<Component> getComponentByType(String type){
        ComponentDAO dao = new ComponentDAO();
        List<Component> list = new ArrayList<>();
        try{
            list = dao.getComponentByType(type);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return list;
    }

    public List<Component> getLstMother() {
        return lstMother;
    }

    public void setLstMother(List<Component> lstMother) {
        this.lstMother = lstMother;
    }

    public List<Component> getLstRam() {
        return lstRam;
    }

    public void setLstRam(List<Component> lstRam) {
        this.lstRam = lstRam;
    }

    public List<Component> getLstDD() {
        return lstDD;
    }

    public void setLstDD(List<Component> lstDD) {
        this.lstDD = lstDD;
    }

    public List<Component> getLstCPU() {
        return lstCPU;
    }

    public void setLstCPU(List<Component> lstCPU) {
        this.lstCPU = lstCPU;
    }

    public List<Component> getLstGPU() {
        return lstGPU;
    }

    public void setLstGPU(List<Component> lstGPU) {
        this.lstGPU = lstGPU;
    }

    public List<String> getLstComputers() {
        return lstComputers;
    }

    public void setLstComputers(List<String> lstComputers) {
        this.lstComputers = lstComputers;
    }

    public Computer getC() {
        return c;
    }

    public void setC(Computer c) {
        this.c = c;
    }

    public String getSelectedComputer() {
        return selectedComputer;
    }

    public void setSelectedComputer(String selectedComputer) {
        this.selectedComputer = selectedComputer;
    }

    public List<Computer> getLstDetails() {
        return lstDetails;
    }

    public void setLstDetails(List<Computer> lstDetails) {
        this.lstDetails = lstDetails;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
    
    
    
    
    
    
    public List<String> getComputers(){
        List<String> list = new ArrayList<>();
        List<Computer> lstComputers = new ArrayList<>();
        ComputerDAO dao;
        try{
            dao = new ComputerDAO();
            lstComputers = dao.show();
            for (int i = 0; i < lstComputers.size(); i++) {
                list.add(lstComputers.get(i).getComputer_id() + " - " + lstComputers.get(i).getModName());
            }
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
                
        return list;
    }
    
    public void selectComputer() throws Exception{
        ComputerDAO dao;
        int computer_id = Integer.parseInt(this.selectedComputer.split(" ")[0]);
        System.out.println(selectedComputer);
        try{
            dao = new ComputerDAO();
            this.c = dao.getComputer(computer_id);
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public void addToCar(){
        this.lstDetails.add(c);
        total = 0;
        for (int i = 0; i < lstDetails.size(); i++) {
            total += lstDetails.get(i).getPriceSale();
        }
    }
    
    
    
}
