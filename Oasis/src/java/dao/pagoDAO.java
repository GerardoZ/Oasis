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
import modelo.pago;
/**
 *
 * @author angel
 */
public class pagoDAO extends DAO{
    public void registrarPago(pago pago)throws Exception{
        try {
            this.Conectar();
            PreparedStatement st= this.getCon().prepareStatement(""
                    + " insert into creditCards (bank,lastFour,num,monthExpiration,yearExpiration,secCode,customer_id) values"
                    + "(?,?,?,?,?,?,"+1+")");
            
            st.setString(1, pago.getBank());
            st.setString(2, pago.getLastFour());
            st.setString(3, Integer.toString(pago.getNum()));
            st.setString(4, pago.getMonthExpiration());
            st.setString(5, pago.getYearExpiration());
            st.setString(6, pago.getSecCode());

            
           

            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("error: "+e);
        }finally{
            this.Cerrar();
        }
    }
    
}
