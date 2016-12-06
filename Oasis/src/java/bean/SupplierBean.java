/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.SupplierDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Supplier;

/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@ViewScoped

public class SupplierBean {
    private Supplier supplier = new Supplier();
    private List<Supplier> lstSuppliers;

    /**
     * Creates a new instance of SupplierBean
     */
    public SupplierBean() throws Exception {
        this.show();
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    

    public List<Supplier> getLstSuppliers() {
        return lstSuppliers;
    }

    public void setLstSuppliers(List<Supplier> lstSuppliers) {
        this.lstSuppliers = lstSuppliers;
    }
    
    public void insert()throws Exception{
        SupplierDAO dao;
        try{
            dao = new SupplierDAO();
            dao.insert(supplier);
            this.show();
        } catch(Exception e){
            throw e;
        }
    }
    
    public void show()throws Exception{
        SupplierDAO dao;
        try{
            dao = new SupplierDAO();
            lstSuppliers = dao.show();
        } catch(Exception e){
            throw e;
        }
    }
    
    
    public void read(Supplier s) throws Exception{    
        Supplier temp;
        SupplierDAO dao;
        try{
            dao = new SupplierDAO();
            temp = dao.read(s);
            if(temp!=null){
                this.supplier = temp;
            }
        } catch(Exception e){
            throw e;
        }
    }
    
    public void update()throws Exception{
        SupplierDAO dao;
        try{
            dao = new SupplierDAO();
            dao.update(supplier);
            this.show();
        } catch(Exception e){
            throw e;
        }
    }
    
    public void delete(Supplier s) throws Exception{
        SupplierDAO dao;
        try{
            dao = new SupplierDAO();
            dao.delete(s);
            this.show();
        } catch(Exception e){
            throw e;
        }
    }
    
    
    
}
