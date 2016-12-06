/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import dao.clienteDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cliente;

/**
 *
 * @author Christopher
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente alumno=new Cliente();
    private  List <Cliente> lstAlumno;
    public ClienteBean() throws Exception {
        this.listar();
    }

    public Cliente getAlumno() {
        return alumno;
    }

    public void setAlumno(Cliente alumno) {
        this.alumno = alumno;
    }

    public List<Cliente> getLstAlumno() {
        return lstAlumno;
    }

    public void setLstAlumno(List<Cliente> lstAlumno) {
        this.lstAlumno = lstAlumno;
    }
    
      
    public void registrar()throws Exception{
        clienteDao dao;
        try {
            dao=new clienteDao();
            dao.registrar(alumno);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar()throws Exception{
        clienteDao dao;
        try {
            dao=new clienteDao();
            lstAlumno=dao.Listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Cliente alu)throws Exception{
        Cliente temp;
        clienteDao dao;
        try {
            dao=new clienteDao();
            temp=dao.leerID(alu);
            if(temp!=null){
                this.alumno=temp;
                
            }
        } catch (Exception e) {
            throw e;
        }
                
                
    }
    public void modificar()throws Exception{
        clienteDao dao;
        try {
            dao=new clienteDao();
            dao.modificar(alumno);
           this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
   public void eliminar(Cliente alum)throws Exception{
        clienteDao dao;
        try {
            dao=new clienteDao();
            dao.eliminar(alum);
           this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
  
}
