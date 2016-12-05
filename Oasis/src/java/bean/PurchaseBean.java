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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Component;
import modelo.Purchase;

/**
 *
 * @author pxndx
 */
@ManagedBean
@ViewScoped

public class PurchaseBean {
    private Purchase purchase = new Purchase();
    private List<Purchase> lstPurchase;
    private List<String> lstComponent=new ArrayList<>();
   
    public PurchaseBean() 
    {
        
        lstComponent.add("prueba");
         try {
           lstComponent = getComponents();
       } catch (Exception ex) {
           Logger.getLogger(PurchaseDAO.class.getName()).log(Level.SEVERE, null, ex);
       }        lstComponent.add("prueba");

    }
    
    
    public List<String> getComponents() throws Exception{
        ComponentDAO componentDAO = new ComponentDAO();
        List<Component> listComponents = componentDAO.show();
        List<String> components = new ArrayList<String>();
        for (int i = 0; i < listComponents.size(); i++) {
            String comp = listComponents.get(i).getComponent_id() + " - " + listComponents.get(i).getModeName();
            components.add(comp);
        }
        return components;
    }

    public List<String> getLstComponent() {
        return lstComponent;
    }

    public void setLstComponent(List<String> lstComponent) {
        this.lstComponent = lstComponent;
    }

    
    
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public List<Purchase> getLstPurchase() {
        return lstPurchase;
    }

    public void setLstPurchase(List<Purchase> lstPurchase) {
        this.lstPurchase = lstPurchase;
    }
    
}
