/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.clienteDao;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import modelo.Cliente;
import org.primefaces.context.RequestContext;

/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@SessionScoped
public class SignBean implements Serializable {
    int currentClient_id;
    private Cliente c = new Cliente();
    
    /**
     * Creates a new instance of SignBean
     */
    public SignBean() {
    }

    public int getCurrentClient_id() {
        return currentClient_id;
    }

    public void setCurrentClient_id(int currentClient_id) {
        this.currentClient_id = currentClient_id;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }
    
    public void registrar()throws Exception{
        clienteDao dao;
        try {
            dao=new clienteDao();
            dao.registrar(c);
                RequestContext.getCurrentInstance().execute("PF('dlgDatos').show()");

        } catch (Exception e) {
            throw e;
        }
    }
    
}
