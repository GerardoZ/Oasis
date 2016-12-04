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
import modelo.Supplier;

/**
 *
 * @author gerardojavierzaratepina
 */
public class SupplierDAO extends DAO{
    public void insert(Supplier s) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("insert into suppliers (rfc, name, contactName, email, contactPhone) values (?,?,?,?,?)");
            st.setString(1, s.getRfc());
            st.setString(2, s.getName());
            st.setString(3,s.getContactName());
            st.setString(4, s.getEmail());
            st.setString(5, s.getContactPhone());
            st.executeUpdate();
        } catch (Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Supplier> show() throws Exception{
        List<Supplier> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from suppliers");
            rs = st.executeQuery();
            while(rs.next()){
                Supplier s = new Supplier();
                s.setSupplier_id(rs.getInt("supplier_id"));
                s.setRfc(rs.getString("rfc"));
                s.setName(rs.getString("name"));
                s.setContactName(rs.getString("contactName"));
                s.setEmail(rs.getString("email"));
                s.setContactPhone(rs.getString("contactPhone"));
                list.add(s);
            } 
        } catch (Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
    
    public Supplier read(Supplier s)throws Exception{
        Supplier supplier = null;
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from suppliers where supplier_id = ?");
            st.setInt(1, s.getSupplier_id());
            rs = st.executeQuery();
            while(rs.next()){
                supplier = new Supplier();
                supplier.setSupplier_id(rs.getInt("supplier_id"));
                supplier.setRfc(rs.getString("rfc"));
                supplier.setName(rs.getString("name"));
                supplier.setContactName(rs.getString("contactName"));
                supplier.setEmail(rs.getString("email"));
                supplier.setContactPhone(rs.getString("contactPhone"));
            }
        } catch(Exception e){
            System.out.println("Error: "+ e);
        } finally{
            this.Cerrar();
        }
        return supplier;
    }
    
    public void update(Supplier s) throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("update suppliers set rfc=?,name=?,contactName=?,email=?,contactPhone=? where supplier_id=?");
            st.setString(1, s.getRfc());
            st.setString(2, s.getName());
            st.setString(3,s.getContactName());
            st.setString(4, s.getEmail());
            st.setString(5, s.getContactPhone());
            st.setInt(6, s.getSupplier_id());
            st.executeUpdate();
        }catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
    
    public void delete(Supplier s)throws Exception{
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("delete from suppliers where supplier_id = ?");
            st.setInt(1, s.getSupplier_id());
            st.executeUpdate();
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
}
