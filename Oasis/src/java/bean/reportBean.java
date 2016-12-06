/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.report;
import dao.reportDAO;
/**
 *
 * @author angel
 */
@ManagedBean
@ViewScoped
public class reportBean {
     private List<report> lstReport1;
     private List<report> lstReport2;
     private List<report> lstReport3;
     private List<report> lstReport4;

    public reportBean() {
        
    }

    public List<report> getLstReport4() {
        return lstReport4;
    }

    public void setLstReport4(List<report> lstReport4) {
        this.lstReport4 = lstReport4;
    }

    
    public List<report> getLstReport3() {
        return lstReport3;
    }

    public void setLstReport3(List<report> lstReport3) {
        this.lstReport3 = lstReport3;
    }

    public List<report> getLstReport1() {
        return lstReport1;
    }

    public void setLstReport1(List<report> lstReport1) {
        this.lstReport1 = lstReport1;
    }

    public List<report> getLstReport2() {
        return lstReport2;
    }

    public void setLstReport2(List<report> lstReport2) {
        this.lstReport2 = lstReport2;
    }
    
    
 
    public void mostrarReporte1() throws Exception{
        try{
            reportDAO report1 = new reportDAO();
            this.lstReport1 =report1.Listar();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }        
    }
    
    public void mostrarReporte2() throws Exception{
        try{
            reportDAO report2 = new reportDAO();
            this.lstReport2 =report2.show1();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }        
    }
    
    public void mostrarReporte3() throws Exception{
        try{
            reportDAO report3 = new reportDAO();
            this.lstReport3 =report3.show2();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }        
    }
    
    public void mostrarReporte4() throws Exception{
        try{
            reportDAO report4 = new reportDAO();
            this.lstReport4 =report4.show3();
        } catch(Exception e){
            System.out.println("Error: " + e);
        }        
    }
    
}
