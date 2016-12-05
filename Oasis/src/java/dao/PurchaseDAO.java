/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Component;
import modelo.Component_Purchase;
import modelo.Purchase;

/**
 *
 * @author pxndx
 */
public class PurchaseDAO extends DAO{
    public void insert(List<Component_Purchase> details, double total, int supplier_id)throws Exception{
        int purchase_id = 0;
        try{
            this.Conectar();
            ResultSet rs;
            PreparedStatement st = this.getCon().prepareStatement("insert into purchases (date, total, supplier_id) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            st.setDouble(2, total);
            st.setInt(3, supplier_id);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                purchase_id = rs.getInt(1);
            }
            for (int i = 0; i < details.size(); i++) {
                PreparedStatement stDetail = this.getCon().prepareStatement("insert into component_purchase (component_id, purchase_id, quantity, charge) values (?,?,?,?)");
                stDetail.setInt(1, details.get(i).getComponent().getComponent_id());
                stDetail.setInt(2, purchase_id);
                stDetail.setInt(3, details.get(i).getQuantity());
                stDetail.setDouble(4, details.get(i).getCharge());
                stDetail.executeUpdate();
            }
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Purchase> show()throws Exception{
        List<Purchase> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from purchases");
            rs = st.executeQuery();
            while(rs.next()){
                Purchase p = new Purchase();
                p.setPurchase_id(rs.getInt("purchase_id"));
                p.setSupplier_id(rs.getInt("supplier_id"));
                p.setDate(rs.getDate("date"));
                p.setTotal(rs.getDouble("total"));
                list.add(p);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
    
    public List<Component_Purchase> readDetails(Purchase p)throws Exception{
        List<Component_Purchase> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from component_purchase where purchase_id = ?");
            st.setInt(1, p.getPurchase_id());
            rs = st.executeQuery();
            while(rs.next()){
                Component_Purchase component_Purchase = new Component_Purchase();
                component_Purchase.setCharge(rs.getDouble("charge"));
                component_Purchase.setQuantity(rs.getInt("quantity"));
                list.add(component_Purchase);
            }
        } catch(Exception e){
            System.out.println("Error: " +e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
   
    
    
}
