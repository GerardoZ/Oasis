/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ComponentDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
    public ComponentBean() {
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
    
}
