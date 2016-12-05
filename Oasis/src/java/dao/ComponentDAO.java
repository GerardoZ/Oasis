/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Component;

/**
 *
 * @author gerardojavierzaratepina
 */

public class ComponentDAO extends DAO{
    public void insert(Component c)throws Exception{
       try{
           this.Conectar();
           PreparedStatement st = this.getCon().prepareStatement("insert into components (code, modName, type, stock, priceSale, pricePurchase, compatibility) value(?,?,?,?,?,?,?)");
           st.setString(1, c.getCode());
           st.setString(2, c.getModeName());
           st.setString(3, c.getType());
           st.setInt(4, c.getStock());
           st.setDouble(5, c.getPriceSale());
           st.setDouble(6, c.getPricePurchase());
           st.setInt(7, c.getCompatibility());
           st.executeUpdate();           
       } catch(Exception e){
           System.out.println("Error: " + e);
       } finally{
           this.Cerrar();
       }
    }
    
    public List<Component> show() throws Exception{
        List<Component> list = new ArrayList<>();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from components");
            rs = st.executeQuery();
            while(rs.next()){
                Component c = new Component();
                c.setComponent_id(rs.getInt("component_id"));
                c.setCode(rs.getString("code"));
                c.setModeName(rs.getString("modName"));
                c.setType(rs.getString("type"));
                c.setStock(rs.getInt("stock"));
                c.setPriceSale(rs.getDouble("priceSale"));
                c.setPricePurchase(rs.getDouble("pricePurchase"));
                c.setCompatibility(rs.getInt("compatibility"));
                list.add(c);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
    
    public Component read(Component c)throws Exception{
        Component component = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from components where component_id = ?");
            st.setInt(1, c.getComponent_id());
            rs = st.executeQuery();
            while(rs.next()){
                component = new Component();
                component.setComponent_id(rs.getInt("component_id"));
                component.setCode(rs.getString("code"));
                component.setModeName(rs.getString("modName"));
                component.setType(rs.getString("type"));
                component.setStock(rs.getInt("stock"));
                component.setPriceSale(rs.getDouble("priceSale"));
                component.setPricePurchase(rs.getDouble("pricePurchase"));
                component.setCompatibility(rs.getInt("compatibility"));
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return component;
    }
    
    public void update(Component c)throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update components set code=?,modName=?,type=?,stock=?,priceSale=?,pricePurchase=?,compatibility=?");
            st.setString(1, c.getCode());
            st.setString(2, c.getModeName());
            st.setString(3, c.getType());
            st.setInt(4, c.getStock());
            st.setDouble(5, c.getPriceSale());
            st.setDouble(6, c.getPricePurchase());
            st.setInt(7, c.getCompatibility());
            st.executeUpdate();
        } catch(Exception e){
            System.out.println("Erros: " + e);
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Component c)throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from components where component_id = ?");
            st.setInt(1, c.getComponent_id());
            st.executeUpdate();
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
}
