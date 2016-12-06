/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ComponentDAO;
import dao.PurchaseDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Component;
import modelo.Component_Purchase;
import modelo.Purchase;

/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@ViewScoped
public class OrdersBean {
    private List<Purchase> lstPurchases = new ArrayList<>();
    private List<Component_Purchase> lstDetails = new ArrayList<>();

    /**
     * Creates a new instance of OrdersBean
     */
    public OrdersBean() throws Exception {
        this.getPurchases();
    }

    public List<Purchase> getLstPurchases() {
        return lstPurchases;
    }

    public void setLstPurchases(List<Purchase> lstPurchases) {
        this.lstPurchases = lstPurchases;
    }

    public List<Component_Purchase> getLstDetails() {
        return lstDetails;
    }

    public void setLstDetails(List<Component_Purchase> lstDetails) {
        this.lstDetails = lstDetails;
    }
    
    
    
    public void getPurchases() throws Exception{
        try{
            PurchaseDAO pdao = new PurchaseDAO();
            this.lstPurchases = pdao.show();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }        
    }
    
    public void read(Purchase p)throws Exception{
        PurchaseDAO dao;
        try{
            dao = new PurchaseDAO();
            lstDetails = dao.readDetails(p);          
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public void delete(Purchase p) throws Exception{
        PurchaseDAO dao;
        try{
            dao = new PurchaseDAO();
            dao.delete(p);
            this.getPurchases();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Compra eliminada exitosamente."));

        } catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
    
    public String getComponentName(int id) throws Exception{
        ComponentDAO dao;
        Component c = null;
        try{
            dao = new ComponentDAO();
            c = dao.getComponent(id);
        } catch(Exception e){
            System.out.println("Error: " + e);
        }      
        return c.getModeName();
    }
    
}
