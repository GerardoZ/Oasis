/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import dao.pagoDAO;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.pago;
/**
 *
 * @author angel
 */
@ManagedBean
@ViewScoped
public class pagoBean {
        private pago pago=new pago();
    private List<pago> lstPago;
    
           
   public pagoBean() {
    }

    public pago getPago() {
        return pago;
    }

    public void setPago(pago pago) {
        this.pago = pago;
    }

    public List<pago> getLstPago() {
        return lstPago;
    }

    public void setLstPago(List<pago> lstPago) {
        this.lstPago = lstPago;
    }
   
    public void registrarPago()throws Exception{
        pagoDAO dao;
        try {
            dao=new pagoDAO();
            dao.registrarPago(pago);
        } catch (Exception e) {
            throw e;
        }
    }
}
