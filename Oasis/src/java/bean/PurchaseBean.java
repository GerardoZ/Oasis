/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ComponentDAO;
import dao.PurchaseDAO;
import dao.SupplierDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Component;
import modelo.Component_Purchase;
import modelo.Purchase;
import modelo.Supplier;

/**
 *
 * @author pxndx
 */
@ManagedBean
@ViewScoped

public class PurchaseBean {
    private Purchase purchase = new Purchase();
    private Component_Purchase cp = new Component_Purchase();
    private List<Component_Purchase> lstPurchase = new ArrayList<>();
    
    private List<String> lstSupplier=new ArrayList<>();
    private List<String> lstComponent=new ArrayList<>();
    private String component;
    private String supplier;
    private int quantity;
    private double total;
   
    public PurchaseBean() 
    {
        
         try {
           lstComponent = getComponents();
           lstSupplier = getSuppliers();
       } catch (Exception ex) {
           Logger.getLogger(PurchaseDAO.class.getName()).log(Level.SEVERE, null, ex);
       }        

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
    
    public List<String> getSuppliers() throws Exception{
        SupplierDAO supplierDAO = new SupplierDAO();
        List<Supplier> listSuppliers = supplierDAO.show();
        List<String> suppliers = new ArrayList<String>();
        for (int i = 0; i < listSuppliers.size(); i++) {
            String supp = listSuppliers.get(i).getSupplier_id() + " = " + listSuppliers.get(i).getName();
            suppliers.add(supp);
        }
        return suppliers;
    }

    public List<String> getLstComponent() {
        return lstComponent;
    }

    public void setLstComponent(List<String> lstComponent) {
        this.lstComponent = lstComponent;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
    
    
    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public List<Component_Purchase> getLstPurchase() {
        return lstPurchase;
    }

    public void setLstPurchase(List<Component_Purchase> lstPurchase) {
        this.lstPurchase = lstPurchase;
    }

    public List<String> getLstSupplier() {
        return lstSupplier;
    }

    public void setLstSupplier(List<String> lstSupplier) {
        this.lstSupplier = lstSupplier;
    }
    
    

    public Component_Purchase getCp() {
        return cp;
    }

    public void setCp(Component_Purchase cp) {
        this.cp = cp;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
    
    
    
    
    
    public void addComponentPurchase() throws Exception{
        Component c = new Component();
        c.setComponent_id(Integer.parseInt(this.component.split(" ")[0]));
        ComponentDAO componentDAO = new ComponentDAO();
        Component_Purchase cp = new Component_Purchase();
        cp.setComponent(componentDAO.read(c));
        cp.setQuantity(this.quantity);
        cp.setCharge((double)cp.getQuantity() * cp.getComponent().getPricePurchase());

        this.lstPurchase.add(cp);
        
        total =0;
        for (int i = 0; i < lstPurchase.size(); i++) {
            total += lstPurchase.get(i).getCharge();
        }
    }
    
    public void insert()throws Exception{
        if(lstPurchase.size() < 1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Agrega al menos un producto."));
        }
        else{
            int supplier_id = Integer.parseInt(this.supplier.split(" ")[0]);
            PurchaseDAO dao;
            try{
                dao = new PurchaseDAO();
                dao.insert(lstPurchase, total, supplier_id);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Compra registrada exitosamente."));
                this.clear();

            } catch(Exception e){
                throw e;
            }
        }
        
    }
    
    public void clear(){
        this.lstPurchase = new ArrayList<>();
    }

    
    
}
