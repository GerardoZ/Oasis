/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ComponentDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Component;


/**
 *
 * @author gerardojavierzaratepina
 */
@ManagedBean
@ViewScoped
public class ComponentBean {
    private Component component = new Component();
    private List<Component> lstComponents;
    /**
     * Creates a new instance of ComponentBean
     */
    public ComponentBean() throws Exception {
        this.show();
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public List<Component> getLstComponents() {
        return lstComponents;
    }

    public void setLstComponents(List<Component> lstComponents) {
        this.lstComponents = lstComponents;
    }
    
    public void insert()throws Exception{
        ComponentDAO dao;
        try{
            dao = new ComponentDAO();
            dao.insert(component);
            this.show();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Componente registrado exitosamente."));

        } catch(Exception e){
            throw e;
        }
    }
    
    public void show()throws Exception{
        ComponentDAO dao;
        try{
            dao = new ComponentDAO();
            lstComponents = dao.show();
        } catch(Exception e){
            throw e;
        }
    }
    
    public void read(Component c)throws Exception{
        Component temp;
        ComponentDAO dao;
        try{
            dao = new ComponentDAO();
            temp = dao.read(c);
            if(temp!=null){
                this.component = temp;
            }
        } catch(Exception e){
            throw e;
        }
    }
    
    public void update() throws Exception{
        ComponentDAO dao;
        try{
            dao = new ComponentDAO();
            dao.update(component);
            this.show();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Componente modificado exitosamente."));

        } catch(Exception e){
            throw e;
        }
    }
    
    public void delete(Component c)throws Exception{
        ComponentDAO dao;
        try{
            dao = new ComponentDAO();
            dao.delete(c);
            this.show();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Componente eliminado exitosamente."));

        } catch(Exception e){
            throw e;
        }
    }
    
    public void clear(){
        this.component.setComponent_id(0);
        this.component.setCode("");
        this.component.setModeName("");
        this.component.setCompatibility(0);
        this.component.setStock(0);
        this.component.setPricePurchase(0);
        this.component.setPriceSale(0);
    }
    
}
