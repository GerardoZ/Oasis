/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import modelo.Computer;

/**
 *
 * @author gerardojavierzaratepina
 */
public class SaleDAO extends DAO{
    public void insert(List<Computer> computers, double total) throws Exception{
        int sale_id = 0;
        try{
            this.Conectar();
            ResultSet rs;
            PreparedStatement st = getCon().prepareStatement("insert into sales (date, total, customer_id) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            st.setDouble(2, total);
            st.setInt(3,clienteDao.id_client);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                sale_id = rs.getInt(1);
            }
            
            for (int i = 0; i < computers.size(); i++) {
                PreparedStatement stDetail = this.getCon().prepareStatement("insert into sales_computer (sale_id, computer_id) values(?,?)");
                stDetail.setInt(1, sale_id);
                stDetail.setInt(2, computers.get(i).getComputer_id());
                stDetail.executeUpdate();
                
                PreparedStatement stGetComponents = this.getCon().prepareStatement("select component_id from components_computer where computer_id = ?");
                stGetComponents.setInt(1, computers.get(i).getComputer_id());
                ResultSet components = stGetComponents.executeQuery();
                while(components.next()){
                    PreparedStatement stGetStock = this.getCon().prepareStatement("select stock from components where component_id = ?");
                    stGetStock.setInt(1, components.getInt(1));
                    ResultSet rsStock = stGetStock.executeQuery();
                    rsStock.first();
                    int stock = rsStock.getInt(1);
                    stock--;
                    
                    PreparedStatement stUpdateStock = this.getCon().prepareStatement("update components set stock = ? where component_id = ?");
                    stUpdateStock.setInt(1, stock);
                    stUpdateStock.setInt(2, components.getInt(1));
                    stUpdateStock.executeUpdate();                
                }
            }
            
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
    }
}
