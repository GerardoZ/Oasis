/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Computer;

/**
 *
 * @author gerardojavierzaratepina
 */
public class ComputerDAO extends DAO{
    public List<Computer> show() throws SQLException{
        List<Computer> list = new ArrayList<>();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select * from computers");
            rs = st.executeQuery();
            while(rs.next()){
                Computer c = new Computer();
                c.setComputer_id(rs.getInt("computer_id"));
                c.setModName(rs.getString("modName"));
                c.setPriceSale(rs.getDouble("priceSale"));
                c.setType(rs.getString("type"));
                list.add(c);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
    
    public Computer getComputer(int id) throws Exception{
        Computer c = new Computer();
        try{
            this.Conectar();
            ResultSet rs;
            PreparedStatement st = getCon().prepareStatement("select * from computers where computer_id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            while(rs.next()){
                c.setComputer_id(rs.getInt("computer_id"));
                c.setModName(rs.getString("modName"));
                c.setPriceSale(rs.getDouble("priceSale"));
                c.setType(rs.getString("type"));
            }
        } catch(Exception e){
            System.out.println("Error:" + e);
        } finally{
            this.Cerrar();
        }
        
        return c;
    }
}
