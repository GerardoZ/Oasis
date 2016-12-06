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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.pago;
import org.primefaces.context.RequestContext;
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
            RequestContext.getCurrentInstance().execute("PF('dlgDatos').hide()");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Listo!!", "Ahora eres un usuario Skynet."));


        } catch (Exception e) {
            throw e;
        }
    }
}
