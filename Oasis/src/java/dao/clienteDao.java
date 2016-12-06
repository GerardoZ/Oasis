package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Christopher
 */
public class clienteDao extends DAO {
    static int id_client = 0;
    
     public void registrar(Cliente client)throws Exception{
        try {
            
            this.Conectar();
            ResultSet rs;
            PreparedStatement st= this.getCon().prepareStatement(""
                    + "insert into customers(name,email,streetAndNumber,neighborhood,zipCode,phone) values"  //CHECAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
                    + "(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, client.getNombre());
            st.setString(2, client.getE_mail());
            st.setString(3, client.getDireccion());
            st.setString(4, client.getColonia());
            st.setString(5, client.getCodigoPostal());
            st.setString(6, client.getTelefono());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            rs.first();
            
            id_client = rs.getInt(1);
            
            
        } catch (Exception e) {
            System.out.println("error: "+e);
        }finally{
            this.Cerrar();
        }
        
     }
        public List<Cliente> Listar()throws Exception{
        List<Cliente> lista;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement(""
                    + "select * from customers");
            rs=st.executeQuery();
            lista=new ArrayList();
            while(rs.next()){
                Cliente alum=new Cliente();
                alum.setCostumer_id(rs.getInt("customer_id"));
                alum.setNombre(rs.getString("name"));
                alum.setE_mail(rs.getString("email"));
                alum.setDireccion(rs.getString("streetAndNumber"));
                alum.setColonia(rs.getString("neighborhood"));
                alum.setCodigoPostal(rs.getString("zipCode"));
                alum.setTelefono(rs.getString("phone"));
                lista.add(alum);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
    
    public Cliente leerID(Cliente clien)throws Exception{
        Cliente clients=null;
        ResultSet rs;
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement(""
                    + "select * from customers where customer_id=?");
            st.setInt(1, clien.getCostumer_id());
            rs=st.executeQuery();
            
            while(rs.next()){
                clients=new Cliente();
                clients.setNombre(rs.getString("name"));
                clients.setE_mail(rs.getString("email"));
                clients.setDireccion(rs.getString("streetAndNumber"));
                clients.setColonia(rs.getString("neighborhood"));
                clients.setCodigoPostal(rs.getString("zipCode"));
                clients.setTelefono(rs.getString("phone"));
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return clients;
    }
    
        public void modificar(Cliente alum)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement(""
           + "update customers set name=?, email=?, streetAndNumber=?, neighborhood=?, zipCode=?, phone=? where customer_id=?");
           st.setString(1, alum.getNombre());
            st.setString(2, alum.getE_mail());
             st.setString(3, alum.getDireccion());
              st.setString(4, alum.getColonia());
              st.setString(5, alum.getCodigoPostal());
              st.setString(6, alum.getTelefono());
              st.setInt(7, alum.getCostumer_id());
              st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public void eliminar(Cliente alum)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement(""+
                    "DELETE FROM customers where customer_id=?");
            st.setInt(1, alum.getCostumer_id());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
   
   
    }

