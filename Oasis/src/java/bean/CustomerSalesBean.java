/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Sale;
import dao.SaleDAO;
import dao.clienteDao;

/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@ViewScoped
public class CustomerSalesBean {
    List<Sale> lstSales = new ArrayList<>();
    clienteDao cDAO = new clienteDao();

    /**
     * Creates a new instance of CustomerSalesBean
     */
    public CustomerSalesBean() {
        this.show();
    }

    public List<Sale> getLstSales() {
        return lstSales;
    }

    public void setLstSales(List<Sale> lstSales) {
        this.lstSales = lstSales;
    }

    public clienteDao getcDAO() {
        return cDAO;
    }

    public void setcDAO(clienteDao cDAO) {
        this.cDAO = cDAO;
    }
    
    
    
    
    public void show(){
        SaleDAO dao;
        try{
            dao = new SaleDAO();
            this.lstSales = dao.show(cDAO.id_client);
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
}
