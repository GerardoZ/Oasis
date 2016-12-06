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
import modelo.report;

/**
 *
 * @author angel
 */
public class reportDAO extends DAO{
    
    public List<report> Listar()throws Exception{
        List<report> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement("select stock, type, priceSale from components;");
            rs=st.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
                report report=new report();
                
                report.setCantidad(rs.getInt("stock"));
                report.setNombre(rs.getString("type"));
                report.setPrecio(rs.getDouble("priceSale"));
                lista.add(report);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    public List<report> show()throws Exception{
        List<report> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select sale_id, fecha, total from sales");
            rs = st.executeQuery();
            while(rs.next()){
                report report=new report();
                
                report.setCantidad(rs.getInt("sale_id"));
                report.setNombre(rs.getString("fecha"));
                report.setPrecio(rs.getDouble("total"));
                list.add(report);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
    
        public List<report> show1()throws Exception{
        List<report> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select nombre from employeds;");
            rs = st.executeQuery();
            while(rs.next()){
                report report=new report();
                
                report.setNombreEmpleado(rs.getString("nombre"));
                list.add(report);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
        
    public List<report> show2()throws Exception{
        List<report> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select s.name, s.rfc, s.email, p.date, p.total from suppliers s inner join purchases p where s.supplier_id = p.supplier_id && status = false;");
            rs = st.executeQuery();
            while(rs.next()){
                report report=new report();
                report.setPurchase_id(rs.getString("name"));
                report.setSupplier_id(rs.getString("rfc"));
                report.setDate(rs.getString("email"));
                report.setStatus(rs.getString("date"));
                report.setTotal(rs.getDouble("total"));
                
                list.add(report);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }

    public List<report> show3()throws Exception{
        List<report> list = new ArrayList();
        ResultSet rs;
        try{
            this.Conectar();
            PreparedStatement st = this.getCon().prepareStatement("select date, total from sales");
            rs = st.executeQuery();
            while(rs.next()){
                report report=new report();
                report.setFechaVenta(rs.getString("date"));
                report.setTotalVenta(rs.getDouble("total"));
                list.add(report);
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        } finally{
            this.Cerrar();
        }
        return list;
    }
   
   
}
